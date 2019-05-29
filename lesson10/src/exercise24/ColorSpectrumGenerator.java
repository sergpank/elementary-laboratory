package exercise24;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ColorSpectrumGenerator
{
  public static void main(String[] args) throws IOException
  {
    ColorSpectrumGenerator colorSpectrumGenerator = new ColorSpectrumGenerator();
    File file = new File("data/colors.html");
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
    bufferedWriter.write(generateFoundation());
    bufferedWriter.write(addColors());

    bufferedWriter.flush();
    bufferedWriter.close();
  }
  public static String generateFoundation()
  {
    return "<html>\n" +
        "\n" +
        "<head>\n" +
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
        "          height: 30px;\n" +
        "          width: 100px;\n" +
        "        }\n" +
        "\n" +
        "    </style>\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "\n" +
        "  <table>\n";
  }
  public static String addColors()
  {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 256; i++)
    {
      sb.append("<tr>\n" +
          "      <td style='background-color: rgb(" + i + ", 0, 0)'></td>\n" +
          "      <td style='background-color: rgb(0, " + i + ", 0)'></td>\n" +
          "      <td style='background-color: rgb(0, 0, " + i + ")'></td>\n" +
          "    </tr>");
    }
    return sb.toString();
  }
}
