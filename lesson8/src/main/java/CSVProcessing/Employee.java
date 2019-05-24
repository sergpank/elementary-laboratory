package CSVProcessing;

public class Employee
{
  private String firstName;
  private String lastName;
  private double age;



  public Employee(String firstName, String lastName, double age)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
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


  @Override
  public String toString()
  {
    return "Employee{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        '}';
  }
}
