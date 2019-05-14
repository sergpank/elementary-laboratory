import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car
{
  private String name;
  private int door;
  private String color;

  public Car (String name, int door, String color)
  {
    this.name = name;
    this.door = door;
    //this.color = color;
    setColor(color);
  }

  public String getColor()
  {
    return color;
  }

  public void setColor(String color)
  {
    Pattern name = Pattern.compile("[a-z]+");
    Matcher name_2 = name.matcher(color);

    if (name_2.matches()){
      this.color = color;
    }
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getDoor()
  {
    return door;
  }

  public void setDoor(int door)
  {
    this.door = door;
  }

  public void speed (){
    System.out.println("km/hour");
  }

  @Override
  public String toString()
  {
    return "Car{" +
        "name='" + name + '\'' +
        ", door=" + door +
        ", color='" + color + '\'' +
        '}';
  }
}
