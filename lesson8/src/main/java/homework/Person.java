package homework;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Person
{
  private int id;
  private Map<String, String> dataMap;

  public Person(int id, Map<String, String> dataMap)
  {
    this.dataMap = dataMap;
    this.id = id;
  }

  public Person(int id, String[] keys, String[] data)
  {
    this.id = id;
    dataMap = initMap(keys, data);
  }

  private HashMap<String, String> initMap(String[] key, String[] data)
  {
    HashMap<String, String> newMap = new HashMap<>();
    for (int i = 0; i < key.length; i++)
    {
      newMap.put(key[i], data[i]);
    }
    return newMap;
  }

  public String getDataByKey(String key)
  {
    if (!dataMap.containsKey(key))
    {
      return null;
    }
    return dataMap.get(key);
  }

  public int getId()
  {
    return id;
  }



  @Override
  public String toString()
  {
    return "Person{Last name " + getDataByKey("Last Name")
        + "; First name "+ getDataByKey("First Name") + "; "
        + "Age " + getDataByKey("Age in Yrs.") + " }";
  }
}
