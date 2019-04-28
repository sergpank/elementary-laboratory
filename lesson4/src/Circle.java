public class Circle extends Point
{
  protected double r, s;

  public Circle(int x, int y, double r)
  {
    super(x, y);
    setR(r);
  }

  public double square()
  {
    s = Math.PI * (r * r);
    return s;
  }

  @Override
  public String toString()
  {
    return "Circle{" + "r=" + r + ", s=" + s + ", x=" + x + ", y=" + y + '}';
  }

  public double getR()
  {
    return r;
  }

  public void setR(double r)
  {
    this.r = r;
  }
}
