package zhuravlov.homework;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
  public static void main(String[] args)
  {
    File file = new File("csv/10000 Records.csv");

    System.out.println(file.getAbsolutePath());

    List<Employee> employees = readEmployees(file);
    long length = employees.stream().count();
    EmployeeMedian employeeMedian = new EmployeeMedian();

   System.out.println("Median salary - " + employeeMedian.MedianSalary(employees));
    System.out.println("Male median salary - " + employeeMedian.GenderMedianSalary(employees, "M"));
    System.out.println("Female median salary - " + employeeMedian.GenderMedianSalary(employees, "F"));
    int percent = 5;
    System.out.println("Average Truncated Salary " + percent + "% " + employeeMedian.AverageTruncatedSalary(employees, percent));
    percent = 10;
    System.out.println("Average Truncated Salary " + percent + "% " + employeeMedian.AverageTruncatedSalary(employees, percent));
    percent = 15;
    System.out.println("Average Truncated Salary " + percent + "% " + employeeMedian.AverageTruncatedSalary(employees, percent));
    percent = 20;
    System.out.println("Average Truncated Salary " + percent + "% " + employeeMedian.AverageTruncatedSalary(employees, percent));
    percent = 25;
    System.out.println("Average Truncated Salary " + percent + "% " + employeeMedian.AverageTruncatedSalary(employees, percent));


    employees.stream()
        .sorted(new EmployeeAgeComporator())
        .map(employee -> (long)(employee.getAge()))
    .forEach(System.out::println);

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