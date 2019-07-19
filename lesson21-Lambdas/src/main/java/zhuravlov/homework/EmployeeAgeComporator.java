package zhuravlov.homework;

import java.util.Comparator;

public class EmployeeAgeComporator implements Comparator<Employee>
{
  @Override
  public int compare(Employee e1, Employee e2)
  {
    return (int)e1.getAge() - (int)e2.getAge();
  }
}
