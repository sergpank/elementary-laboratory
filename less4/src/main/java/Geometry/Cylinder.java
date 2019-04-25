package Geometry;

public class Cylinder extends Circle
{
  private int h;
  private double area;
  private double volume;

  public Cylinder(int x, int y, int r, int h)
  {
    super(r, x, y);
    super.circleArea();
    this.h = h;
  }

  @Override
  public double circleArea()
  {
    double a = 2 * super.getArea() + (2 * super.getR() * Math.PI * getH());
    return this.area = a;
  }

  public double cylinderVolume()
  {
    double v = super.getArea() * getH();
    return this.volume = v;
  }

  @Override
  public String toString()
  {
    return "Cylinder{" +
        "x=" + super.getX() +
        ", y=" + super.getY() +
        ", radius=" + super.getR() +
        ", height= " + getH() + ", area=" + getArea() + ", volume=" + getVolume() +
        '}';
  }

  public double getArea()
  {
    return area;
  }

  public double getVolume()
  {
    return volume;
  }

  public int getH()
  {
    return h;
  }
}
