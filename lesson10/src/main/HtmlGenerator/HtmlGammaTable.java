package main.HtmlGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlGammaTable
{
  public static void main(String[] args)
  {
    HtmlGammaTable html = new HtmlGammaTable();
    html.write();
  }
  public void write()
  {
    File file = new File("GammaColorTable.html");
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
    {
      writer.write(generateHtml());
      writer.flush();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  public String generateHtml()
  {
    return "<html>\n" + generateHead() + "\n" + generateBody() +"\n" + "</html>";
  }

  private String generateHead()
  {
    return "<head>\n" +generateStyle()+"\n"+"</head>\n";
  }

  private String generateBody()
  {
    return "<body>\n" + generateTable() + "\n" + "</body>\n";
  }

  private String generateStyle()
  {
    return "<style>\n" + generateTableSettings() + "\n" + "</style>\n";
  }

  private String generateTableSettings()
  {
    return " table {\n" +
        "    border-collapse: collapse;\n" +
        "    table-layout:fixed;\n" +
        "   }\n"+
        " table, th, td {\n" +
        "    border: 1px solid black;\n" +
        "   }\n" +
        " td {\n" +
        "    height: 1px;\n" +
        "    width: 100px;\n" +
        "   }\n";
  }

  private String generateTable()
  {
    return "<table>\n" + generateColorGamma() + "\n" + "</table>\n";
  }

  private StringBuilder generateColorGamma()
  {
    StringBuilder colors= new StringBuilder();
    for(int i = 1; i<256; i++)
    {
      colors.append(String.format("<tr>\n<td style='background-color: rgb(%d, 0, 0)'></td>\n" +
          "<td style='background-color: rgb(0, %d, 0)'></td>\n" +
          "<td style='background-color: rgb(0, 0, %d)'></td>\n</tr>\n", i,i,i));
    }
    return colors;
  }
}
