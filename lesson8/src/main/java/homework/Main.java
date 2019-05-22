package homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    String path = "src/main/java/resources/";
    String name = "10000 Records.csv";

    File file = new File(path + name);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String str;
    Map<Integer, HashMap<String, String>> mapPerson = new TreeMap<>();
    String[] keys = new String[]{"No working"};
    boolean title = false;
    while ((str = reader.readLine()) != null)
    {
      String[] temp = str.split(",");
      if (!title)
      {
        keys = temp;
        title = true;
      }
      else
      {
        HashMap<String, String> mapString = new HashMap<>();
        for (int i = 1; i < temp.length; i++)
        {
          int id = Integer.parseInt(temp[0]);
          mapString.put(keys[i], temp[i]);
          mapPerson.put(id, mapString);
        }
      }
    }

    for (Map.Entry<Integer, HashMap<String, String>> pair : mapPerson.entrySet())
    {
      System.out.print(pair.getKey() + ", ");
      for (Map.Entry<String, String> pair2 : pair.getValue().entrySet())
      {
        System.out.print(pair2.getValue() + ", ");
      }
      System.out.println();
    }

  }
}
