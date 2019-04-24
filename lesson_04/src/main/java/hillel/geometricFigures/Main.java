package main.java.hillel.geometricFigures;

public class Main
{

  public static void main(String[] args)
  {
    Point point1 = new Point(0, 0);
    Circle circle1 = new Circle(0, 0, 1);
    Cylinder cylinder1 = new Cylinder(0, 0, 1, 2);

    System.out.println(point1);
    System.out.println(circle1);
    System.out.println(cylinder1);

    System.out.println("Circle square = " + circle1.square());
    System.out.println("Cylinder square = " + cylinder1.square());
    System.out.println("Cylinder volume = " + cylinder1.volume());

  }
}
