package homework14;

public class Circle extends Point
{
  private double radius;

  public Circle(double x, double y, double radius)
  {
    super(x, y);
    this.radius = radius;
  }

  public double getRadius()
  {
    return radius;
  }

  public double getSquare()
  {
    return Math.PI * Math.pow(radius, 2);
  }

  @Override
  public String toString()
  {
    return String.format("Круг с радиусом равным %.2f и координатами центра: x=%.2f, y=%.2f",
        radius, getCoordX(), getCoordY());
  }
}
