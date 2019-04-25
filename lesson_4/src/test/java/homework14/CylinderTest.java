package homework14;

import org.junit.Test;

import static org.junit.Assert.*;

public class CylinderTest
{
  @Test
  public void test()
  {
    double x = 2;
    double y = 3;
    double radius = 10;
    double height = 30;

    Cylinder cylinder = new Cylinder(x, y, radius, height);

    String expected = "Цилиндр с высотой равной 30,00, радиусом основания 10,00 и координатами центра основания: x=2,00, y=3,00";


    assertTrue(height == cylinder.getHeight());
    assertTrue(Math.PI * Math.pow(radius, 2) * height == cylinder.getVolume());
    assertTrue(Math.PI * 2 * radius * height + 2 * Math.PI * Math.pow(radius, 2) == cylinder.getSquare());
    assertTrue(expected.equals(cylinder.toString()));
  }
}
