package lesson_08_hometask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile
{
  public static void main(String[] args) throws IOException
  {
    File records = new File("D:\\Hillel Java\\IdeaProjects\\Github\\elementary-laboratory\\lesson_08\\10000 Records.csv");
    ReadFile(records);
  }

  private static void ReadFile(File records) throws IOException
  {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(records)))
    {
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {

        System.out.println(line);
      }
      //System.out.println(line);
    }
  }
}
