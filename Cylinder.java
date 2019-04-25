package hillel.lesson4.Figure;

public class Cylinder extends Circle
{
  protected int heightCylinder;

  public Cylinder(int x, int y, int radius, int heightCylinder)
  {
    super(x, y, radius);
    this.heightCylinder = heightCylinder;
  }

  public int getHeightCylinder()
  {
    return heightCylinder;
  }

  public void setHeightCylinder(int heightCylinder)
  {
    this.heightCylinder = heightCylinder;
  }

  protected double areaCircleCylinder()
  {
    double area = radius * radius * Math.PI;
    return area;
  }

  protected double areaAllCylinder()
  {
    double areaAll = (circleArea() * 2) + (2 * Math.PI * radius * heightCylinder);
    return areaAll;
  }

  protected double cylindeVolume()
  {
    double volume = circleArea() * heightCylinder;
    return volume;
  }

  @Override
  public String toString()
  {
    return "Cylinder{" +
        "heightCylinder=" + heightCylinder +
        ", radius=" + radius +
        ", x=" + x +
        ", y=" + y +
        '}';
  }
}
