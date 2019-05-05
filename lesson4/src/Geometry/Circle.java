package Geometry;

public class Circle extends Point
{
  private double r;   

  protected Circle(double x, double y, double r)
  {
    super(x, y);
    if (r > 0)
    {
      this.r = r;
    }
  }

  protected double getSquare()
  {
    return Math.PI * Math.pow(r, 2);
  }

  @Override
  public String toString()
  {
    return super.toString() + " r=" + r + "; square=" + getSquare() + ";";
  }

  protected double getR()
  {
    return r;
  }
}
