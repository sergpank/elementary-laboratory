package zhuravlov.homework;

import java.util.Comparator;

class EmployeeSalaryComporator implements Comparator<Employee>
{
  @Override
  public int compare(Employee e1, Employee e2)
  {
    return (e1.getSalary() - e2.getSalary());
  }
}
