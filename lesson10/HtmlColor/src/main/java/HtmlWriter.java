import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlWriter
{
  StringBuilder sb = new StringBuilder();

  public void rgbColor()
  {
    sb.append("<html> \n");
    sb.append(createHead());
    sb.append(createBody());
    sb.append("</html> \n");
    writeHtml(sb);
  }

  private StringBuilder createHead()
  {
    StringBuilder sbHead = new StringBuilder();

     sbHead.append("\n ")
         .append("<head> \n")
         .append("     <style> \n")
         .append("           table { \n")
         .append("             border-collapse: collapse; \n")
         .append("             table-layout:fixed; \n ")
         .append("                 } \n")
         .append("           table, th, td { \n")
         .append("             border: 1px solid black; \n")
         .append("                          } \n ")
         .append(" \n ")
         .append("            td { \n")
         .append("              height: 1px; \n")
         .append("              width: 100px; \n")
         .append("               } \n")
         .append(" \n ")
         .append("      </style> \n ")
         .append("</head> \n");

    return sbHead;
  }

  private StringBuilder createBody()
  {
    StringBuilder sbBody = new StringBuilder();

     sbBody.append("<body> \n")
          .append("\n")
          .append("      <table> \n")
          .append("\n")

          .append(rgbColors())

          .append("      </table> \n ")
          .append("</body> \n ");

    return sbBody;
  }

  private StringBuilder rgbColors()
  {
    StringBuilder sbRgb = new StringBuilder();

    for (int i = 1; i < 256; i++)
    {
      sbRgb.append("        <tr> \n")
          .append("<td style = 'background-color: rgb(").append(i).append(", 0, 0)' ></td > \n")
          .append("<td style = 'background-color: rgb(0, ").append(i).append(", 0)' ></td > \n")
          .append("<td style = 'background-color: rgb(0, 0, ").append(i).append(")' ></td > \n")
          .append("        </tr> \n")
          .append("\n");
    }
    return sbRgb;
  }

  private void writeHtml(StringBuilder htmlText)
  {
    File file = new File("rgbColor.txt");
    BufferedWriter bw = null;
    try
    {
      bw = new BufferedWriter(new FileWriter(file));
      bw.write(htmlText.toString());
      bw.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    System.out.println("Writing of HTML text done! ");
  }

}
