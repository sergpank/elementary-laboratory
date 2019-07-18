package homeworke;

import java.util.List;
import java.util.stream.Collectors;

public class Middler
{
  public int getmiddle(List<Employee> employees)
  {
    return (int) (employees.stream()
        .mapToLong(value -> value.getSalary())
        .sum() /
        employees.stream().count());
  }

  public int getmiddle(List<Employee> employees, String gender)
  {
    return (int) (employees.stream()
        .filter(employee -> employee.getGender().equals(gender))
        .mapToLong(value -> value.getSalary())
        .sum() /
        employees.stream().count());
  }

  public int getmiddle(List<Employee> employees, int cut)
  {
    return (int) (employees.stream()
        .mapToLong(value -> value.getSalary() * (100 - cut) / 100)
        .sum()/employees.size());
  }

  public int getmiddle(List<Employee> employees, int min, int max)
  {
    List<Employee> employeesFilter = employees.stream()
        .filter(employee -> employee.getAge() > min && employee.getAge() <= max)
        .collect(Collectors.toList());

       return(int) employeesFilter.stream().mapToLong(value -> value.getSalary())
        .sum()/
        employeesFilter.size();

  }
}
