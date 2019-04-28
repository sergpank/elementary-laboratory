package Geometry;

public class Point
{
  protected int x, y;

  public Point(int x, int y)
  {
    setX(x);
    setY(y);
  }

  @Override
  public String toString()
  {
    return "Geometry.Point{" + "x=" + x + ", y=" + y + '}';
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public void setY(int y)
  {
    this.y = y;
  }
}
