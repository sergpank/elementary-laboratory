package rvelikorod;

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
    File file = new File("csv/10000 Records.csv");

//    System.out.println(file.getAbsolutePath());

    List<Employee> employees = readEmployees(file);
    System.out.println("median salary of all employees = " + Accountant.medianSalary(employees));
    System.out.println("median salary of all male employees = " + Accountant.medianSalaryByGender(employees, "M"));
    System.out.println("median salary of all female employees = " + Accountant.medianSalaryByGender(employees, "F"));
    System.out.println("median salary of all employees with age from 20-25 years = " + Accountant.ageGroupMedianSalary(employees, 20));
    System.out.println("5% truntcated salary of all employees = " + Accountant.truncatedMeanSalary(employees, 5));
    System.out.println("10% truntcated salary of all employees = " + Accountant.truncatedMeanSalary(employees, 10));
    System.out.println("15% truntcated salary of all employees = " + Accountant.truncatedMeanSalary(employees, 15));
    System.out.println("20% truntcated salary of all employees = " + Accountant.truncatedMeanSalary(employees, 20));
    System.out.println("25% truntcated salary of all employees = " + Accountant.truncatedMeanSalary(employees, 25));
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
        int salary = Integer.valueOf(split[headerIndexes.get("Salary")]);

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