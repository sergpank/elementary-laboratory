package Geometry;

public class Point
{
  private double x;
  private double y;

  protected Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString()
  {
    return "x=" + x + "; y=" + y + ";";
  }

  protected double getX()
  {
    return x;
  }

  protected double getY()
  {
    return y;
  }
}
