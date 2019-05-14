public class Lkw extends Car
{
  public String hight;

  public Lkw (String name, int door, String color, String hight)
  {
    super(name, door, color);
    this.hight = hight;
  }

  @Override
  public String toString()
  {
    return "Car{" +
        "name='" + getName() + '\'' +
        ", door=" + getDoor() +
        ", color='" + super.getColor() + '\'' + ", hight= " + this.hight +
        '}';
  }
}
