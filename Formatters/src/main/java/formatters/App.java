package formatters;

import formatters.formatter.FormatterFactory;
import formatters.formatter.IFormatter;
import formatters.graph.FileGraph;

import java.io.File;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try
        {
            File f=new File("files/input/acm1_test_file_in.txt");
            Scanner sc=new Scanner(f);

            String inputFormat=sc.nextLine();
            String outputFormat=sc.nextLine();

            IFormatter inputFormatter= FormatterFactory.getFormatter(inputFormat);

            IFormatter outputFormatter=FormatterFactory.getFormatter(outputFormat);

            FileGraph g=inputFormatter.parse(sc);

            sc.close();
            System.out.println();
            g.display();
            System.out.println();
            System.out.println(outputFormatter.format(g));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
