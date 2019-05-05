package Geometry;

public class App
{
  public static void main(String[] args)
  {
    Point p = new Point(2, 2);
    System.out.println(p);
    Circle c = new Circle(2, 2, 2);
    System.out.println(c);
    Cylinder cy = new Cylinder(2, 2, 2, 2);
    System.out.println(cy);
  }
}
