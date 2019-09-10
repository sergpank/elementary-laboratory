package formatters;

import formatters.formatter.FormatterFactory;
import formatters.formatter.IFormatter;
import formatters.graph.FileGraph;

import java.io.*;
import java.util.Scanner;

public class Util
{
  public static String format(String inputFile)
  {
    return format(inputFile, null);
  }

  public static String format(String inputFile, String targetFormat)
  {
    String result=null;
    try
    {
      File f=new File(inputFile);
      Scanner sc=new Scanner(f);

      String inputFormat=sc.nextLine();
      String outputFormat=sc.nextLine();

      if(targetFormat!=null)
      {
        outputFormat=targetFormat;
      }

      IFormatter inputFormatter= FormatterFactory.getFormatter(inputFormat);

      IFormatter outputFormatter=FormatterFactory.getFormatter(outputFormat);

      FileGraph g=inputFormatter.parse(sc);

      sc.close();

      result=outputFormatter.format(g);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  public static boolean fileComparator(String file1, String file2)
  {
    boolean result = true;

    try (BufferedReader r1 = new BufferedReader(new FileReader(file1));
         BufferedReader r2 = new BufferedReader(new FileReader(file2)))
    {

      while(true)
      {
        int x1=r1.read();
        int x2=r2.read();
        if(x1!=x2)
        {
          result=false;
          break;
        }
        if(x1==-1)
        {
          break;
        }

      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }



    return result;
  }

  public static void writeOutput(String output, String path)
  {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(path)))
    {
      w.write(output);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }


}
