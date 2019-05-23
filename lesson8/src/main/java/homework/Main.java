package homework;

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    String path = "src/main/java/resources/";
    String name = "10000 Records.csv";


    Map<Integer, Person> mapPerson = createData(path, name);


    Map<String, Set<Integer>> ageIdSet1 = max_min(mapPerson);

    showMaxMin(mapPerson, ageIdSet1);

  }

  private static void showMaxMin(Map<Integer, Person> mapPerson, Map<String, Set<Integer>> ageIdSet1)
  {
    for (Map.Entry<String, Set<Integer>> pair : ageIdSet1.entrySet())
    {
      Iterator iterator = pair.getValue().iterator();
      while (iterator.hasNext())
      {
        System.out.printf("Status %s : ids %s\n", pair.getKey(), mapPerson.get(iterator.next()));
      }
    }
  }

  private static Map<Integer, Person> createData(String path, String name) throws IOException
  {
    Map<Integer, Person> mapPerson = new TreeMap<>();
    File file = new File(path + name);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String str;
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
        Person person = new Person(id, keys, temp);
        mapPerson.put(id, person);
      }
    }
    return mapPerson;
  }

  private static Map<String, Set<Integer>> max_min(Map<Integer, Person> mapPerson)
  {
    Map<String, Set<Integer>> ageIdSet = new TreeMap<>();
    String min = "Min";
    String max = "Max";

    for (Map.Entry<Integer, Person> pair : mapPerson.entrySet())
    {
      Double age = Double.parseDouble(pair.getValue().getDataByKey("Age in Yrs."));
      if (ageIdSet.size() == 0)
      {
        TreeSet<Integer> ids = new TreeSet<>();
        ids.add(pair.getKey());
        ageIdSet.put(max, ids);
        ageIdSet.put(min, ids);
      }
      else
      {
        Double tempMax = Double.parseDouble(mapPerson.get(ageIdSet.get(max).iterator().next()).getDataByKey("Age in Yrs."));
        if (tempMax == age)
        {
          ageIdSet.get(max).add(pair.getKey());
        }
        else if (tempMax < age)
        {
          TreeSet<Integer> maxSet = new TreeSet<>();
          maxSet.add(pair.getKey());
          ageIdSet.put(max, maxSet);
        }
        Double tempMin = Double.parseDouble(mapPerson.get(ageIdSet.get(min).iterator().next()).getDataByKey("Age in Yrs."));
        if (tempMax == age)
        {
          ageIdSet.get(min).add(pair.getKey());
        }
        else if (tempMin > age)
        {
          TreeSet<Integer> minSet = new TreeSet<>();
          minSet.add(pair.getKey());
          ageIdSet.put(min, minSet);
        }
      }
    }
    return ageIdSet;
  }private static Map<String, Set<Integer>> rankName(Map<Integer, Person> mapPerson)
  {
    Map<String, Set<Integer>> ageIdSet = new TreeMap<>();
    String min = "Min";
    String max = "Max";

    for (Map.Entry<Integer, Person> pair : mapPerson.entrySet())
    {
      Double age = Double.parseDouble(pair.getValue().getDataByKey("Age in Yrs."));
      if (ageIdSet.size() == 0)
      {
        TreeSet<Integer> ids = new TreeSet<>();
        ids.add(pair.getKey());
        ageIdSet.put(max, ids);
        ageIdSet.put(min, ids);
      }
      else
      {
        Double tempMax = Double.parseDouble(mapPerson.get(ageIdSet.get(max).iterator().next()).getDataByKey("Age in Yrs."));
        if (tempMax == age)
        {
          ageIdSet.get(max).add(pair.getKey());
        }
        else if (tempMax < age)
        {
          TreeSet<Integer> maxSet = new TreeSet<>();
          maxSet.add(pair.getKey());
          ageIdSet.put(max, maxSet);
        }
        Double tempMin = Double.parseDouble(mapPerson.get(ageIdSet.get(min).iterator().next()).getDataByKey("Age in Yrs."));
        if (tempMax == age)
        {
          ageIdSet.get(min).add(pair.getKey());
        }
        else if (tempMin > age)
        {
          TreeSet<Integer> minSet = new TreeSet<>();
          minSet.add(pair.getKey());
          ageIdSet.put(min, minSet);
        }
      }
    }
    return ageIdSet;
  }
}
