package homework14;

public class Point
{
  private double coordX;
  private double coordY;

  public Point(double x, double y)
  {
    this.coordX = x;
    this.coordY = y;
  }

  public double getCoordX()
  {
    return coordX;
  }

  public double getCoordY()
  {
    return coordY;
  }

  @Override
  public String toString()
  {
    return String.format("Точка с координатами: x=%.2f, y=%.2f", coordX, coordY);
  }
}
