package fedorov;

import java.util.List;

public class main
{
  public static void main(String[] args)
  {
    List<Employee> employees = EmployeeReader.readEmployee();

    System.out.println("median salary is  " + Calculator.getMedianSalary(employees));
    System.out.println("median salary for mans is " + Calculator.getMaleMedianSalary(employees));
    System.out.println("median salary for womens is " + Calculator.getFemaleMedianSalary(employees));
    System.out.println("median salary for all employees 30-35 years is " + Calculator.getAgeGroupMedianSalary(employees, 30));
    System.out.println("5% truntcated median salary is " + Calculator.getTruntcatedMedianSalary(employees, 5));
    System.out.println("10% truntcated median salary is " + Calculator.getTruntcatedMedianSalary(employees, 10));
    System.out.println("15% truntcated median salary is " + Calculator.getTruntcatedMedianSalary(employees, 15));
    System.out.println("20% truntcated median salary is " + Calculator.getTruntcatedMedianSalary(employees, 20));
    System.out.println("25% truntcated median salary is " + Calculator.getTruntcatedMedianSalary(employees, 25));
  }
}
