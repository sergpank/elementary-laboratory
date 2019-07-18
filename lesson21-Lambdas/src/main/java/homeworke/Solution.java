package homeworke;

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
    File file = new File("csv/100000 Records.csv");

    System.out.println(file.getAbsolutePath());

    List<Employee> employees = readEmployees(file);

    Middler middler = new Middler();

    System.out.printf("MiddleSalary - %d\n", middler.getmiddle(employees));
    System.out.printf("MiddleSalary for man - %d\n", middler.getmiddle(employees, "M"));
    System.out.printf("MiddleSalary for woman - %d\n", middler.getmiddle(employees, "F"));

    for (int i = 5; i <= 25; i += 5)
    {
      System.out.printf("MiddleSalary cut %d procents - %d\n", i, middler.getmiddle(employees, i));
    }

    int older = (int) employees.stream().mapToDouble(value -> value.getAge()).max().getAsDouble();

    System.out.println();

    for (int i = 20; i <= older - 5; i += 5)
    {
      int min = i, max = i + 5;

      System.out.printf("MiddleSalary min = %d max = %d - %d\n", min, max, middler.getmiddle(employees, min, max));
    }

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
        int salary = Integer.parseInt(split[headerIndexes.get("Salary")]);

        employees.add(new Employee(firsName, lastName, age, gender, salary));
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