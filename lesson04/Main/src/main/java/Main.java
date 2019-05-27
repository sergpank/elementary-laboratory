
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

  public static class Point
  {
    private int x;
    private int y;

    public Point(int x, int y)
    {
      this.x = x;
      this.y = y;
    }

    public int getX()
    {
      return x;
    }

    public void setX(int x)
    {
      this.x = x;
    }

    public int getY()
    {
      return y;
    }

    public void setY(int y)
    {
      this.y = y;
    }

    @Override
    public String toString()
    {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }



  public static class Circle extends Point
  {
    private int radius;


    public Circle(int x, int y, int radius)
    {
      super(x, y);
      this.radius = radius;
    }

    public double square(){
      double square = Math.PI*radius*radius;
      return square;
    }

    public int getRadius()
    {
      return radius;
    }

    public void setRadius(int radius)
    {
      this.radius = radius;
    }

    @Override
    public String toString()
    {
      return "Circle{" +
          "x=" + super.getX() +
          ", y=" + super.getY() +
          ", radius=" + radius +
          '}';

    }
  }

  public static class Cylinder extends Circle
  {
    private int height;

    public Cylinder(int x, int y, int radius, int height)
    {
      super(x, y, radius);
      this.height = height;
    }

    @Override
    public double square()
    {
      double square = 2*super.square() + (2 * super.getRadius() * Math.PI * this.height);
      return square;
    }

    public double volume()
    {
      double volume = super.square()*getHeight();
      return volume;
    }

    public int getHeight()
    {
      return height;
    }

    public void setHeight(int height)
    {
      this.height = height;
    }


    @Override
    public String toString()
    {
      return "Cylinder{" +
          "x=" + super.getX() +
          ", y=" + super.getY() +
          ", radius=" + super.getRadius() +
          ", height= " + height +
          '}';

    }
  }

}
