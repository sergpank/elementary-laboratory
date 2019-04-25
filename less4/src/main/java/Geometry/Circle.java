package Geometry;

public class Circle extends Point
{
  private int r;
  private double area;

  public Circle(int r, int x, int y)
  {
    super(x, y);
    this.r = r;
  }

  public double circleArea()
  {
    double a = Math.PI * Math.pow(getR(), 2);
    return this.area = a;

  }

  @Override
  public String toString()
  {
    return ("Circle{" +
        "x=" + super.getX() +
        ", y=" + super.getY() +
        ", radius=" + getR() + ", area=" + getArea() +
        '}');

  }

  public double getArea()
  {
    return area;
  }

  public int getR()
  {
    return r;
  }
}
