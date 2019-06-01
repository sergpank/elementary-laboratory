import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLGenerator
{
  public static void main(String[] args)
  {
    File file = new File ( "D:\\GitHillel\\Lesson10\\rgbtable.html" );
    try
    {
      file.createNewFile ( );
      BufferedWriter bw = new BufferedWriter ( new FileWriter ( file , false ) );
      bw.write ( "<html>" );
      bw.close ( );
      createHead ( file );
      createBody ( file );
      BufferedWriter bw2 = new BufferedWriter ( new FileWriter ( file , true ) );
      bw2.write ( "\n</html>" );
      bw2.close ( );
    }
    catch (IOException e)
    {

      e.printStackTrace ( );
    }
  }

  public static void createHead(File file)
  {
    try
    {
      BufferedWriter bw = new BufferedWriter ( new FileWriter ( file , true ) );
      StringBuilder stringBuilder = new StringBuilder ( );

      stringBuilder.append ( "\n<head>\n" +
          "    <style>\n" +
          "        table {\n" +
          "          border-collapse: collapse;\n" +
          "          table-layout:fixed;\n" +
          "        }\n" +
          "\n" +
          "        table, th, td {\n" +
          "          border: 1px solid black;\n" +
          "        }\n" +
          "\n" +
          "        td {\n" +
          "          height: 1px;\n" +
          "          width: 100px;\n" +
          "        }\n" +
          "\n" +
          "    </style>\n" +
          "</head>" );
      bw.write ( stringBuilder.toString ( ) );
      bw.close ( );
    }
    catch (IOException e)
    {

      e.printStackTrace ( );
    }
  }


  public static void createBody(File file)
  {
    try
    {
      BufferedWriter bw = new BufferedWriter ( new FileWriter ( file , true ) );
      bw.write ( "\n<body>\n<table>" );
      rgbTable ( bw );
      bw.write ( "\n</table>\n</body>" );
      bw.close ( );
    }
    catch (IOException e)
    {

      e.printStackTrace ( );
    }

  }

  private static void rgbTable(BufferedWriter bw) throws IOException
  {
    StringBuilder stringBuilder = new StringBuilder ( );
    for ( int i = 1 ; i <= 255 ; i++ )
    {
      stringBuilder.append ( "\n<tr>\n<td style='background-color: rgb(" ).append ( i ).append ( ", 0, 0)'></td>" );
      stringBuilder.append ( "\n<td style='background-color: rgb(0, " ).append ( i ).append ( ", 0)'></td>" );
      stringBuilder.append ( "\n<td style='background-color: rgb(0, 0, " ).append ( i ).append ( ")'></td>\n</tr>" );
    }
    bw.write ( stringBuilder.toString ( ) );
  }


}



