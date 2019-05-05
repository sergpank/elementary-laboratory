package Geometry;

public class Cylinder extends Circle
{
  private double h; 

  protected Cylinder(double x, double y, double r, double h)
  {
    super(x, y, r);
    if (h > 0)
    {
      this.h = h;
    }
  }

  protected double getSquare()
  {
    return (2 * super.getSquare()) + (2 * Math.PI * getR() * h);
  }

  private double volume()
  {
    return Math.PI * Math.pow(getR(), 2) * h;
  }

  @Override
  public String toString()
  {
    return super.toString() + " h=" + h + "; volume=" + volume() + ";";
  }
}
