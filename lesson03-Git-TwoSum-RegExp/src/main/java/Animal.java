import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Animal
{
  private  String name;
  private  int age;
  public static String type;

  public  Animal(String name, int age)
  {
    setAge(age);
    setName(name);

    System.out.println("Hello!");

  }

  public String calculate(){

    return  name;

  }

  public void move()
  {
    System.out.println("run run run");
  }


  public String getName()
  {
    return name;
  }

  public void setName(String name)

  {
    Pattern proverka = Pattern.compile("[A-Z]{3}");
    Matcher matcher = proverka.matcher(name);
    if (matcher.matches())
    {

      this.name = name;
    }
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    if (age < 100 && age > 0)
    {
      this.age = age;
    }
    else
    {
      System.out.println("Input correct age from 0 to 100");
    }
  }

  @Override
  public String toString()
  {
    return "Animal{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}'+
        "type "+ type;
  }
}




