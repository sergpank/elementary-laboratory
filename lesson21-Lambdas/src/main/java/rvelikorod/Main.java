package rvelikorod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
  public static void main(String[] args)
  {
    Employee e1 = new Employee("BOB", "BROWN", 20, "M", 2);
    Employee e2 = new Employee("BOB", "BROWN", 25, "F", 5);
    Employee e3 = new Employee("BOB", "BROWN", 25, "M", 11);
    Employee e4 = new Employee("BOB", "BROWN", 56, "M", 12);
    Employee e5 = new Employee("BOB", "BROWN", 34, "M", 15);
    Employee e6 = new Employee("BOB", "BROWN", 21, "F", 3);
    Employee e7 = new Employee("BOB", "BROWN", 20, "F", 7);
    Employee e8 = new Employee("BOB", "BROWN", 36, "M", 6);
    Employee e9 = new Employee("BOB", "BROWN", 45, "F", 9);
    Employee e10 = new Employee("BOB", "BROWN", 23, "M", 20);
    Employee e11 = new Employee("BOB", "BROWN", 23, "M", 23);

    List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);


    System.out.println("median salary of all employees  = " + Accountant.medianSalary(employees));
    System.out.println("median salary of all male employees  = " + Accountant.medianSalaryByGender(employees, "M"));
    System.out.println("median salary of all employees with age from 20-25 years = " + Accountant.ageGroupMedianSalary(employees, 20));
    System.out.println("truntcated salary of all employees  = " + Accountant.truncatedMeanSalary(employees, 10));
  }





}
