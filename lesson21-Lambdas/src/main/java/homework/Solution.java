package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution
{
  public static void main(String[] args)
  {
    File file = new File("lesson21-Lambdas/csv/10000 Records.csv");

    System.out.println(file.getAbsolutePath());

    List<Employee> employees = readEmployees(file);

    Set<String> firstNames = employees.stream()
        .map(e -> e.getFirstName())
        .collect(Collectors.toSet());

    List<Employee> millenials = employees.stream()
        .filter(e -> e.getAge() > 20 && e.getAge() < 30)
        //.sorted((e1, e2) -> {return (int) (e1.getAge() - e2.getAge());})
        .sorted(Comparator.comparingDouble(Employee::getAge))
        //.map(Employee::getLastName)
        .collect(Collectors.toList());

    millenials.forEach(m -> System.out.printf("%2.2f - %s\n", m.getAge(), m.getLastName()));
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
        String gender = split[headerIndexes.get("Gender")];

        employees.add(new Employee(firsName, lastName, age, gender));
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