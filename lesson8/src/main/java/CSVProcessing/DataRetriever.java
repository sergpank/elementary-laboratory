package CSVProcessing;

import java.io.*;
import java.util.*;

public class DataRetriever
{
  private String fileName;

  public DataRetriever(String fileName)
  {
    this.fileName = fileName;
  }

  public static void main(String[] args)
  {


    DataRetriever a = new DataRetriever("10000 Records.csv");

    a.sortbyAge();
  }

  public void sortbyAge()
  {
    TreeSet<Employee> empSet = new TreeSet<>(new Comparator<Employee>()
    {
      @Override
      public int compare(Employee o1, Employee o2)
      {


        return Double.compare(o1.getAge(), o2.getAge());
      }
    });

    empSet.addAll(readEmployee());

    System.out.println(empSet.first());
    System.out.println(empSet.last());


  }

  public void sortbyName()
  {

    HashMap<String, Integer> nameMap = new HashMap<>();

    List<Employee> employees = readEmployee();

    for (Employee e : employees)
    {
      Integer count = nameMap.get(e.getFirstName());

      if (count == null)
      {
        count = 0;
      }
      count++;

      nameMap.put(e.getFirstName(), count);

    }
    // System.out.println(nameMap);


    Map<Integer, Set<String>> cntName = new TreeMap<>(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o2 - o1;
      }
    });

    for (Map.Entry<String, Integer> el : nameMap.entrySet())
    {
      Integer nameCnt = el.getValue();
      String name = el.getKey();
      Set<String> namesSet = cntName.get(nameCnt);

      if (namesSet == null)
      {
        namesSet = new HashSet<>();
        cntName.put(nameCnt, namesSet);
      }

      namesSet.add(name);
    }


    Iterator<Map.Entry<Integer, Set<String>>> iterator = cntName.entrySet().iterator();

    int c = 0;
    while (c++ < 3)
    {

      if (iterator.hasNext())
      {
        System.out.println(iterator.next());
      }
      else
      {
        break;
      }


    }


  }


  public List readEmployee()
  {

    String separator = File.separator;
    String path = "lesson8" + separator + "src" + separator + "main" + separator + "java" + separator + "CSVFiles" + separator;
    File tmp = new File(path + fileName);

    List<Employee> employees = new ArrayList<>();

    String line;


    try (BufferedReader br = new BufferedReader(new FileReader(tmp)))
    {

      line = br.readLine();

      HashMap<String, Integer> headerIndex = getHeaderIndex(line);


      while (true)
      {

        line = br.readLine();
        if (line == null)
        {
          break;
        }
        String[] split = line.split(",");
        String name = split[headerIndex.get("First Name")];
        String lastname = split[headerIndex.get("Last Name")];
        double age = Double.valueOf(split[headerIndex.get("Age in Yrs.")]);

        employees.add(new Employee(name, lastname, age));


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

    return employees;
  }

  private HashMap getHeaderIndex(String line)
  {
    HashMap<String, Integer> headerIndex = new HashMap<>();

    String[] split = line.split(",");

    for (int i = 0; i < split.length; i++)
    {
      headerIndex.put(split[i], i);
    }
    return headerIndex;
  }


}
