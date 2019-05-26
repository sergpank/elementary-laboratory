import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class PersonSort
{
  List<String> fileList = new ArrayList<>();
  Map<String, Integer> mapName = new HashMap<>();
  List<Person> personList = new ArrayList<>();

  public static void main(String[] args)
  {
    PersonSort personSort = new PersonSort();
    personSort.go();
  }

  private void go()
  {
    getPersonInfo();
    sortName();
    sortYangAge();
    sortOldAge();
  }

  private void getPersonInfo()
  {
    File file = new File("10000 Records.csv");
    {
      try
      {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null)
        {
          fileList.add(line);
        }
        fileList.remove(0);
        for (String words : fileList)
        {

          addToCollections(words);
        }
      }
      catch (java.io.IOException e)
      {
        e.printStackTrace();
      }
    }
  }

  private void addToCollections(String line)
  {
    String[] token = line.split(",");

    String lastName = token[2];
    String firstName = token[4];
    String age = token[12];

    mapName.put(lastName, mapName.containsKey(lastName) ? mapName.get(lastName) + 1 : 1);

    Person person = new Person(lastName, firstName, age);
    personList.add(person);
  }

  private void sortName()
  {

    List list = new ArrayList(mapName.entrySet());
    MaxCountComparator maxCountComparator = new MaxCountComparator();
    Collections.sort(list, maxCountComparator);
    for (int i = 0; i < list.size(); i++)
    {
      if (i < 3)
      {
        System.out.println("Popular name : " + list.get(i));
      }
    }
    System.out.println(" ");

    /*
    String popularName = Collections.max(mapName.entrySet(), Map.Entry.comparingByValue()).getKey();
    System.out.println("Most popular name is " + popularName);
    */
  }

  private void sortYangAge()
  {
    AgeYangComparator ageYangComparator = new AgeYangComparator();
    Collections.sort(personList, ageYangComparator);
    for (int i = 0; i < personList.size(); i++)
    {
      if (i < 3)
      {
        System.out.println("Yang person : " + personList.get(i));
      }
    }
    System.out.println(" ");
  }

  private void sortOldAge()
  {
    AgeOldComparator ageOldComparator = new AgeOldComparator();
    Collections.sort(personList, ageOldComparator);
    for (int i = 0; i < personList.size(); i++)
    {
      if (i < 3)
      {
        System.out.println("Old person : " + personList.get(i));
      }
    }
    System.out.println(" ");
  }


}


class Person
{
  private String firsttName;
  private String lastName;
  private String age;

  public Person(String firsttName, String lastName, String age)
  {
    this.firsttName = firsttName;
    this.lastName = lastName;
    this.age = age;
  }


  public String getFirsttName()
  {
    return firsttName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getAge()
  {
    return age;
  }

  @Override
  public String toString()
  {
    return "Person{ " + firsttName + " "
        + lastName + " " +
        ", age='" + age + '\'' +
        '}';
  }
}

class MaxCountComparator implements Comparator<Map.Entry<String, Integer>>
{

  @Override
  public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
  {
    return o2.getValue().compareTo(o1.getValue());
  }
}

class AgeYangComparator implements Comparator<Person>
{

  @Override
  public int compare(Person o1, Person o2)
  {
    return o1.getAge().compareTo(o2.getAge());
  }
}

class AgeOldComparator implements Comparator<Person>
{

  @Override
  public int compare(Person o1, Person o2)
  {
    return o2.getAge().compareTo(o1.getAge());
  }
}








