package zhuravlov.homework;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeMedian
{
  public static long MedianSalary(List<Employee> employees)
  {
    long mediansalary = 0;
    long length = employees.stream().count();


    mediansalary = employees.stream()
        .sorted(new EmployeeSalaryComporator())
        .skip(length/2 - 1)
        .limit(2)
        .map(employee -> employee.getSalary())
        .reduce((x, y) -> (x + y) / 2)
        .get();

    return mediansalary;
  }

  public static long GenderMedianSalary(List<Employee> employees, String gender)
  {
    long mediansalary = 0;
    long length = employees.stream()
        .filter(employee -> employee.getGender().equals(gender))
        .count();

    mediansalary = employees.stream()
        .filter(employee -> employee.getGender().equals(gender))
        .sorted(new EmployeeSalaryComporator())
        .skip(length/2 - 1)
        .limit(2)
        .map(employee -> employee.getSalary())
        .reduce((x, y) -> (x + y) / 2)
        .get();

    return mediansalary;
  }

  public static long AverageTruncatedSalary(List<Employee> employees, int percent)
  {
    long mediansalary = 0;
    long length = employees.stream().count();
    long truncate = percent*length/100;
    long newlenght = (length-(truncate*2));

    long salarysum = employees.stream()
        .sorted(new EmployeeSalaryComporator())
        .skip(truncate)
        .limit(newlenght)
        .map(employee -> Long.valueOf(employee.getSalary()))
        .reduce((x, y) -> (x + y))
        .get();

    mediansalary = salarysum/newlenght;
    return mediansalary;
  }

  public static long AgeTruncatedSalary(List<Employee> employees, double age)
  {
    long mediansalary = 0;
    long length = employees.stream().count();


    employees.stream()
        .sorted(new EmployeeAgeComporator())
        .map(employee -> (long)(employee.getAge()));


    return mediansalary;
  }

}
