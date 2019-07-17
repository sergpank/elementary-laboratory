package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
  public static void main(String[] args)
  {
    File file = new File("lesson21-Lambdas/csv/10000 Records.csv");

    System.out.println(file.getAbsolutePath());

    int sumOfSquares = IntStream.of(1, 10)
        .map(i -> i * i)
        .reduce((a, b) -> a + b)
        .getAsInt();

    System.out.println(sumOfSquares);
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