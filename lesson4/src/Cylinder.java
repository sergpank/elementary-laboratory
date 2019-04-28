public class Cylinder extends Circle
{
  protected double h, s, v;

  public Cylinder(int x, int y, double r, double h)
  {
    super(x, y, r);
    setH(h);
  }

  public double square()
  {
    s = 2 * Math.PI * r * (r + h);
    return s;
  }

  public double volume()
  {
    v = Math.PI * (r * r) * h;
    return v;
  }

  @Override
  public String toString()
  {
    return "Cylinder{" + "h=" + h + ", s=" + s + ", v=" + v + ", r=" + r + ", s=" + s + ", x=" + x + ", y=" + y + '}';
  }

  public double getH()
  {
    return h;
  }

  public void setH(double h)
  {
    this.h = h;
  }
}
