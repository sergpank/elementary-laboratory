package Task_14;

public class App
{
  public static void main(String[] args)
  {
    Point point1 = new Point(0,0);
    System.out.println(point1);

    Circle circle1 = new Circle(3,4,10);
    System.out.println(circle1);
    circle1.square();

    Cylinder cylinder1 = new Cylinder(1,1,10,20);
    System.out.println(cylinder1);
    System.out.println("cylinder bulk equals = " + cylinder1.cylinder());
  }
}
