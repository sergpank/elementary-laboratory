package homework14;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest
{
  @Test
  public void test()
  {

    double x = 2.567;
    double y = 3;

    Point p = new Point(x, y);

    assertTrue(x == p.getCoordX());
    assertTrue(y == p.getCoordY());
    assertTrue("Точка с координатами: x=2,57, y=3,00".equals(p.toString()));
  }
}
