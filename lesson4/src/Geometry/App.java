package Geometry;

public class App
{
  public static void main(String[] args)
  {
    Circle circle = new Circle(5, 7, 11);
    System.out.println(circle);
    circle.square();
    System.out.println(circle);
    Cylinder s = new Cylinder(2, 2, 6, 6);
    s.square();
    s.volume();
    System.out.println(s);


  }
}
