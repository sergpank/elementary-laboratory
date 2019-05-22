package homework;

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    String path = "src/main/java/resources/";
    String name = "10000 Records.csv";

    File file = new File(path + name);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String str;
    Set<Person> mapPerson = new TreeSet<Person>(new ComparatorPerson());
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
        int id = Integer.parseInt(temp[0]);
        Person person = new Person(id,keys,temp);
        mapPerson.add(person);
      }
    }
    Iterator iterator = mapPerson.iterator();
    System.out.println(mapPerson.size());
      while (iterator.hasNext()){
        Person person = (Person)iterator.next();
        System.out.println(person.getDataByKey("Age in Yrs."));
        System.out.println();
      }

    /*for (Map.Entry<Integer, Person> pair : mapPerson.entrySet())
    {
      System.out.print(pair.getKey() + ", ");
      Person person = pair.getValue();
      person.showPair();
      System.out.println();
    }*/

  }
}
