package files;

import java.io.*;

public class BufferedReaderDemo
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("buffered-file-demo.txt");

    writeFile(file);
    readFile(file);

    System.out.println(file.getAbsolutePath());
  }

  private static void writeFile(File file) throws IOException
  {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file)))
    {
      for (int i = 1; i <= 100_000; i++)
      {
        bufferedWriter.write("Line " + i);
        bufferedWriter.newLine();
      }
    }
  }

  private static void readFile(File file) throws IOException
  {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
    {
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
        System.out.println(line);
      }
    }
  }
}
