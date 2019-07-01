package zhuravlov.ball;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Ball
{
  private double x;
  private double y;
  private int dx;
  private double size;
  private Color color;

  public Ball(double x, double y, int dx, double size, Color color)
  {
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.size = size;
    this.color = color;
  }


  public void move(Rectangle bounds, List<Ball> ballList)
  {
    for (Ball o : ballList)
    {
      double t = x;
      x=t+dx;
    }
    checkBoundsX(bounds);
  }


  public void checkBoundsX(Rectangle bounds)
  {
    if (x + size > bounds.getMaxX())
    {
      x = bounds.getMaxX() - size;
      dx = -dx;
    }
    else if (x < bounds.getMinX())
    {
      x = bounds.getMinX();
      dx = -dx;
    }
  }

  public Shape getShape()
  {
    Ellipse2D el = new Ellipse2D.Double(x, y, size, size);
    return el;
  }

  public Color getColor()
  {
    return this.color;
  }

}
