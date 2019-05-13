package hillel.lesson04a;



public class Circle extends Dot
{
 private int radius;
 private double area;

  public Circle(int x, int y, int radius)
  {
    super(x, y);

   this.radius=radius;
  }

  public int getRadius()
  {
    return radius;
  }

  public double getArea()
  {
    return area;
  }

  public double calcAria(){

    double s = Math.PI*radius*radius;

    return this.area=s;

  }

  @Override
  public String toString()
  {

    return "Circle{" +
        "radius=" + radius +
        ", area=" + area +
        '}';
  }
}
