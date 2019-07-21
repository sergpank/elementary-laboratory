package homework_36.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee
{
  private String firstName;
  private String lastName;
  private String namePrefix;
  private String midInitial;
  private LocalDate birthDate;
  private String gender;
  private double salary;

  public Employee(String firstName, String lastName, String namePrefix, String midInitial, LocalDate birthDate, String gender, double salary)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.namePrefix = namePrefix;
    this.midInitial = midInitial;
    this.birthDate = birthDate;
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

  public String getNamePrefix()
  {
    return namePrefix;
  }

  public String getMidInitial()
  {
    return midInitial;
  }

  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  public String getGender()
  {
    return gender;
  }

  public double getSalary()
  {
    return salary;
  }

  public int getAge()
  {
    LocalDate now = LocalDate.now();

    return (now.getMonth().getValue() >= birthDate.getMonth().getValue() &&
        now.getDayOfMonth()>=birthDate.getDayOfMonth()) ? now.getYear() - birthDate.getYear() :
        now.getYear() - birthDate.getYear() - 1;
  }

  @Override
  public String toString()
  {
    return String.format("%s %s %s. %s; age: %d, salary: %.2f;",
        namePrefix,firstName,midInitial,lastName, getAge(), salary);
  }
}
