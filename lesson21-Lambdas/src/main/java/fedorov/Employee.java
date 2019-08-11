package fedorov;

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

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public double getAge()
  {
    return age;
  }

  public void setAge(double age)
  {
    this.age = age;
  }

  public String getGender()
  {
    return gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  public int getSalary()
  {
    return salary;
  }

  public void setSalary(int salary)
  {
    this.salary = salary;
  }

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
