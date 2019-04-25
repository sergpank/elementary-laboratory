package Task_14;

public class Circle extends Point
{
  public int radius;
  public Circle(int x, int y, int radius)
  {
    super(x, y);
    this.radius=radius;
  }

  public void square(){
    double square = Math.PI*Math.pow(this.radius,2);
    System.out.println("cylinder square equals = " + square);
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
