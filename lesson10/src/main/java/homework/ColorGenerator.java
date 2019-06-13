package homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ColorGenerator
{
    String head = "<html>\n" +
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
            "          height: 1px;\n" +
            "          width: 300px;\n" +
            "          padding: -3px;\n" +
            "          margin: -3px;\n" +
            "        }\n" +
            "\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>";

    String tail = "</body>\n" +
            "</html>";

    public static void main(String[] args)
    {
        new ColorGenerator().generate();
    }

    private void generate()
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("colorTable.html"));)
        {
            bw.write(head);

            generateTable(bw);

            bw.write(tail);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void generateTable(BufferedWriter bw) throws IOException
    {
        bw.write("<table>");
        for (int i = 0; i <= 255; i++)
        {
            generateRow(bw, i);
        }
        bw.write("</table>");
        bw.newLine();
    }

    private void generateRow(BufferedWriter bw, int i) throws IOException
    {
        bw.write("<tr>");

        generateCell(bw, i, 0, 0);
        generateCell(bw, 0, i, 0);
        generateCell(bw, 0, 0, i);
        generateCell(bw, i, 0, i);

        bw.write("</tr>");
        bw.newLine();
    }

    private void generateCell(BufferedWriter bw, int red, int green, int blue) throws IOException
    {
        final String style = String.format("style='background-color: rgb(%d, %d, %d)'", red, green, blue);

        bw.write(String.format("<td %s>", style));

//        bw.write(String.format("%d %d %d", red, green, blue));

        bw.write("</td>");
        bw.newLine();
    }
}
