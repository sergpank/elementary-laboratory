

public class Cylinder extends Circle
{
  private int height;

  public Cylinder(int x, int y, int radius, int height)
  {
    super(x, y, radius);
    this.height = height;
  }

  @Override
  public double square()
  {
    double square = 2*super.square() + (2 * super.getRadius() * Math.PI * this.height);
    return square;
  }

  public double volume()
  {
    double volume = super.square()*getHeight();
    return volume;
  }

  public int getHeight()
  {
    return height;
  }

  public void setHeight(int height)
  {
    this.height = height;
  }


  @Override
  public String toString()
  {
    return "Cylinder{" +
        "x=" + super.getX() +
        ", y=" + super.getY() +
        ", radius=" + super.getRadius() +
        ", height= " + height +
        '}';

  }
}
