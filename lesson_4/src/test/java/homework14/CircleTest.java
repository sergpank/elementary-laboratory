package homework14;

import org.junit.Test;

import static org.junit.Assert.*;


public class CircleTest
{
  @Test
  public void test()
  {
    double x = 23.45;
    double y = 12.67;
    double radius = 45.82;

    Circle circle = new Circle(x, y, radius);

    String expected = "Круг с радиусом равным 45,82 и координатами центра: x=23,45, y=12,67";

    assertTrue(radius == circle.getRadius());
    assertTrue(Math.PI * Math.pow(radius, 2) == circle.getSquare());
    assertTrue(expected.equals(circle.toString()));
  }
}
