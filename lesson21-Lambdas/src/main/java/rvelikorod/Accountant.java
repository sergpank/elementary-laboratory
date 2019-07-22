package rvelikorod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Accountant
{
  public static int medianSalary(List<Employee> employees)
  {
    if(employees.size()%2==1)
    {
      return employees.stream()
          .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
          .skip(employees.size()/2).limit(1)
          .map((employee) -> employee.getSalary())
          .findAny().get();
    }
    else
    {
      return employees.stream()
          .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
          .skip(employees.size()/2-1).limit(2)
          .map(employee -> employee.getSalary())
          .reduce((x, y)->(x+y)/2).get();
    }
  }

  public static int medianSalaryByGender(List<Employee> employees, String gender)
  {
    if(employees.size()%2==1)
    {
      List<Employee> filteredList = employees.stream()
          .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
          .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
          .collect(Collectors.toList());
      return filteredList.stream()
          .skip(filteredList.size()/2).limit(2)
          .map(employee -> employee.getSalary())
          .findAny().get();
    }
    else
    {
      List<Employee> filteredList = employees.stream()
          .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
          .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
          .collect(Collectors.toList());
      return filteredList.stream()
          .skip(filteredList.size()/2-1).limit(2)
          .map(employee -> employee.getSalary())
          .reduce((x, y)->(x+y)/2).get();
    }
  }

  public static double truncatedMeanSalary(List <Employee> employees, double percent)
  {
    long length = employees.size();
    double truncate = percent * length / 100;
    double trimmedLength = length - truncate*2;
    long sum = employees.stream()
        .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
        .skip((long)truncate)
        .limit(length-(long)truncate-1)
        .map(employee -> employee.getSalary())
        .reduce((x, y)->x+y).get();
    return sum/trimmedLength;
  }

  public static long ageGroupMedianSalary(List <Employee> employees, double minAge)
  {
    List<Employee> ageGroup = employees.stream()
        .filter(employee -> employee.getAge()>=minAge)
        .filter(employee -> employee.getAge()<=minAge+5)
        .collect(Collectors.toList());
    if(ageGroup.size()%2==1)
    {
      return ageGroup.stream()
          .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
          .skip(ageGroup.size()/2).limit(1)
          .map((employee) -> employee.getSalary())
          .findAny().get();
    }
    else
    {
      return ageGroup.stream()
          .sorted((e1, e2)->Long.compare(e1.getSalary(),e2.getSalary()))
          .skip(ageGroup.size()/2-1).limit(2)
          .map(employee -> employee.getSalary())
          .reduce((x, y)->(x+y)/2).get();
    }
  }
}
