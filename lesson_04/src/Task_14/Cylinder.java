package Task_14;

public class Cylinder extends Circle
{
  public int height;

  public Cylinder(int x, int y, int radius, int height)
  {
    super(x, y, radius);
    this.height = height;
  }

  public double cylinder ()
  {
    double bulk = Math.PI*Math.pow(this.radius,2)*this.height;
    //System.out.println("cylinder bulk equals = " + bulk);
    return bulk;
  }

  @Override
  public String toString()
  {
    return "Cylinder{" +
        "height=" + height +
        ", radius=" + radius +
        ", x=" + x +
        ", y=" + y +
        '}';
  }
}
