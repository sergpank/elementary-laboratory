package lesson_08_hometask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile
{
  public static void main(String[] args)
  {
    ReadFile();
  }

  private static void ReadFile()
  {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Hillel Java\\IdeaProjects\\Github\\elementary-laboratory\\lesson_08\\10000 Records.csv")))
    {
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
        System.out.println(line);
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
