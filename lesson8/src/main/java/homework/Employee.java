package homework;

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
    final StringBuilder sb = new StringBuilder("Employee{");
    sb.append("firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }
}