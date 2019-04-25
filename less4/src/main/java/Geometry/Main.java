package Geometry;

public class Main
{
  public static void main(String[] args)
  {
    Circle circle = new Circle(2, 2, 4);
    circle.circleArea();
    Cylinder cylinder = new Cylinder(2, 4, 2, 6);
    cylinder.circleArea();
    cylinder.cylinderVolume();
    System.out.println(circle + "\n" + cylinder);
  }
}
