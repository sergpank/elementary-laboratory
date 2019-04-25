package hillel.lesson4.Figure;

public class Circle extends Point
{
  protected int radius;

  public Circle(int x, int y, int radius)
  {
    super(x, y);
    this.radius = radius;
  }

  public int getRadius()
  {
    return radius;
  }

  public void setRadius(int radius)
  {
    this.radius = radius;
  }

  protected double circleArea()
  {
    double area = radius * radius * Math.PI;
    return area;
  }

  @Override
  public String toString()
  {
    return "Circle{" +
        "radius=" + radius +
        ", x=" + x +
        ", y=" + y +
        '}';
  }
}
