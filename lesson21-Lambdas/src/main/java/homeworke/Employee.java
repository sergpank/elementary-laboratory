package homeworke;

public class Employee
{
  private String firstName;
  private String lastName;
  private double age;
  private String gender;
  private int salary;

  public Employee(String firstName, String lastName, double age, String gender,int salary)
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

  public int getSalary()
  {
    return salary;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("Employee{");
    sb.append("firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", gender='").append(gender).append('\'');
    sb.append(", salary='").append(salary).append('\'');
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }
}
