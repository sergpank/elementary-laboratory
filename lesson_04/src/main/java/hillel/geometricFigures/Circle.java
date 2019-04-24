package main.java.hillel.geometricFigures;

public class Circle extends Point
{
  private int radius;


  public Circle(int x, int y, int radius)
  {
    super(x, y);
    this.radius = radius;
  }

  public double square(){
    double square = Math.PI*radius*radius;
    return square;
  }

  public int getRadius()
  {
    return radius;
  }

  public void setRadius(int radius)
  {
    this.radius = radius;
  }

  @Override
  public String toString()
  {
    return "Circle{" +
        "x=" + super.getX() +
        ", y=" + super.getY() +
        ", radius=" + radius +
        '}';

  }
}
