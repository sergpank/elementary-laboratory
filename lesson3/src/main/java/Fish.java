public class Fish extends Animal

{
  public String color;

  public Fish(String name, int age, String color)
  {
    super(name, age);
    this.color = color;
  }


  @Override
  public void move()
  {
    System.out.println("swim swim swim");
  }
}
