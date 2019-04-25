package homework14;

public class Cylinder extends Circle
{
  private double height;

  public Cylinder(double x, double y, double radius, double height)
  {
    super(x, y, radius);
    this.height = height;
  }

  public double getHeight()
  {
    return height;
  }

  public double getVolume()
  {
    return super.getSquare() * height;
  }

  @Override
  public double getSquare()
  {
    return super.getSquare() * 2 + Math.PI * 2 * getRadius() * height;
  }

  @Override
  public String toString()
  {
    return String.format("Цилиндр с высотой равной %.2f, радиусом основания %.2f" +
            " и координатами центра основания: x=%.2f, y=%.2f",
        height, getRadius(), getCoordX(), getCoordY());
  }
}
