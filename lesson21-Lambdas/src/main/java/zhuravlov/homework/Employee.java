package zhuravlov.homework;

import java.util.Comparator;

public class Employee
{
  private String firstName;
  private String lastName;
  private double age;
  private String gender;
  private int salary;

  public Employee(String firstName, String lastName, double age, String gender, int salary)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.salary = salary;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public double getAge()
  {
    return age;
  }

  public String getGender()
  {
    return gender;
  }

  public int getSalary() { return salary; }

  @Override
  public String toString()
  {
    return "Employee{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", gender='" + gender + '\'' +
        ", salary=" + salary +
        '}';
  }

}
