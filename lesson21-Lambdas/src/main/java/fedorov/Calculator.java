package fedorov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator
{
  public static int getMedianSalary(List<Employee> employees)
  {
    List<Integer> salaryList = new ArrayList<>();
    for(Employee e : employees)
    {
      salaryList.add(e.getSalary());
    }
    Collections.sort(salaryList);
    return calculateMedian(salaryList);
  }

  public static int getFemaleMedianSalary(List<Employee> employees)
  {
    List<Integer> salaryList = new ArrayList<>();
    for(Employee e : employees)
    {
      if(e.getGender().equals(new String("F")))
      {
        salaryList.add(e.getSalary());
      }
    }
    Collections.sort(salaryList);
    return calculateMedian(salaryList);
  }

  public static int getMaleMedianSalary(List<Employee> employees)
  {
    List<Integer> salaryList = new ArrayList<>();
    for(Employee e : employees)
    {
      if(e.getGender().equals(new String("M")))
      {
        salaryList.add(e.getSalary());
      }
    }
    Collections.sort(salaryList);
    return calculateMedian(salaryList);
  }

  public static int getAgeGroupMedianSalary(List<Employee> employees, int i)
  {
    return 0;
  }

  public static int getTruntcatedMedianSalary(List<Employee> employees, int percent)
  {
    return 0;
  }

  private static int calculateMedian(List<Integer> salaryList)
  {
    if((salaryList.size() % 2) != 0)
    {
      return (salaryList.get(salaryList.size()/2) + salaryList.get((salaryList.size()/2) + 1)) / 2;
    };

    return salaryList.get(salaryList.size()/2);
  }
}
