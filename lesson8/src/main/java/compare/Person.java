package compare;

public class Person implements Comparable<Person>
{
  private int age;

  public Person(int age)
  {
    this.age = age;
  }

  public int getAge()
  {
    return age;
  }

  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("Person {").append(age).append("}");

    return sb.toString();
  }

  @Override
  public int compareTo(Person other)
  {
    return other.getAge() - this.getAge();
  }
}
