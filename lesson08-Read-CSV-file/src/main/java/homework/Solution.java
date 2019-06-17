package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
  public static void main(String[] args)
  {
    File file = new File("lesson8/csv/10000 Records.csv");

    System.out.println(file.getAbsolutePath());

    List<Employee> employees = readEmployees(file);

    Map<String, Integer> nameMap = new HashMap<>();

    for (Employee e : employees)
    {
      Integer cnt = nameMap.get(e.getFirstName());

      if (cnt == null)
      {
        cnt = 0;
      }
      cnt++;
      nameMap.put(e.getLastName(), cnt);
    }

    Map<Integer, Set<String>> cntMap = new TreeMap<>(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o2 - o1;
      }
    });

    for (Map.Entry<String, Integer> e : nameMap.entrySet())
    {
      String name = e.getKey();
      Integer nameCount = e.getValue();

      Set<String> names = cntMap.get(nameCount);

      if (names == null)
      {
        names = new HashSet<>();
        cntMap.put(nameCount, names);
      }
      names.add(name);
    }

    Iterator<Map.Entry<Integer, Set<String>>> iterator = cntMap.entrySet().iterator();
    while (iterator.hasNext())
    {
      System.out.println(iterator.next());
    }

    TreeSet<Employee> employeesSet = new TreeSet<>(new Comparator<Employee>()
    {
      @Override
      public int compare(Employee o1, Employee o2)
      {
        return Double.compare(o1.getAge(), o2.getAge());
      }
    });

    employeesSet.addAll(employees);

    System.out.println("\nYoungest : " + employeesSet.first());
    System.out.println("Oldest   : " + employeesSet.last());
  }

  private static List<Employee> readEmployees(File file)
  {
    List<Employee> employees = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file)))
    {
      String line;

      line = br.readLine();
      Map<String, Integer> headerIndexes = getHeaderIndexes(line);


      while ((line = br.readLine()) != null)
      {
        String[] split = line.split(",");
        String firsName = split[headerIndexes.get("First Name")];
        String lastName = split[headerIndexes.get("Last Name")];
        double age = Double.valueOf(split[headerIndexes.get("Age in Yrs.")]);

        employees.add(new Employee(firsName, lastName, age));
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return employees;
  }

  private static Map<String, Integer> getHeaderIndexes(String line)
  {
    String[] split = line.split(",");

    Map<String, Integer> headerIndexMap = new HashMap<>();

    for (int i = 0; i < split.length; i++)
    {
      headerIndexMap.put(split[i], i);
    }

    return headerIndexMap;
  }
}