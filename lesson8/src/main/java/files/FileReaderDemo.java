package files;

import java.io.*;
import java.util.Arrays;

public class FileReaderDemo
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("plain-file-demo.txt");

    writeFile(file);
    readFile(file);

    System.out.println(file.getAbsolutePath());
  }

  private static void writeFile(File file) throws IOException
  {
    try (FileWriter fileWriter = new FileWriter(file))
    {
      for (int i = 1; i <= 100_000; i++)
      {
        fileWriter
            .append("Line ")
            .append(String.valueOf(i))
            .append("\n");
      }
    }
  }

  private static void readFile(File file) throws IOException
  {
    try (FileReader fileReader = new FileReader(file))
    {
      char[] buffer = new char[1024];

      int size;
      while ((size = fileReader.read(buffer)) != -1)
      {
        char[] string = Arrays.copyOfRange(buffer, 0, size);
        System.out.println(new String(string));
      }
    }
  }
}
