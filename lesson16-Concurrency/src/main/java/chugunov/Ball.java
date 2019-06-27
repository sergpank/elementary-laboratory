package chugunov;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Ball
{
  private double x;
  private double y;
  private int dx;
  private int dy;
  private double size;
  private Color color;

  public Ball(double posX, double posY, int speed, double size, Color color)
  {
    this.x = posX;
    this.y = posY;
    this.dx = speed;
    this.dy = speed;
    this.size = size;
    this.color = color;
  }

  public void move(Rectangle bounds, List<Ball> others)
  {
    moveX(others);
    checkBoundsX(bounds);
    moveY(others);
    checkBoundsY(bounds);
  }

  private void moveX(List<Ball> others)
  {
    boolean wasMoved = false;

    for (Ball o : others)
    {
      if (o != this && (y + size > o.y && y <= o.y + o.size))
      {
        if (x + dx + size > o.x && x + dx + size < o.x + o.size / 3)
        {
          x = o.x - size;
          wasMoved = true;
        }
        else if (x + dx < o.x + o.size && x + dx > o.x + 2 * o.size / 3)
        {
          x = o.x + o.size;
          wasMoved = true;
        }
      }
    }

    if (wasMoved)
    {
      dx = -dx;
    }
    else
    {
      x += dx;
    }
  }

  private void moveY(List<Ball> others)
  {
    boolean wasMoved = false;

    for (Ball o : others)
    {
      if (o != this && (x + size >= o.x && x <= o.x + o.size))
      {
        if (y + dy + size > o.y && y + dy + size < o.y + o.size / 3)
        {
          y = o.y - size;
          wasMoved = true;
        }
        else if (y + dy < o.y + o.size && y + dy > o.y + 2 * o.size / 3)
        {
          y = o.y + o.size;
          wasMoved = true;
        }
      }
    }

    if (wasMoved)
    {
      dy = -dy;
    }
    else
    {
      y += dy;
    }
  }

  private void checkBoundsY(Rectangle bounds)
  {
    if (y + size > bounds.getMaxY())
    {
      y = bounds.getMaxY() - size;
      dy = -dy;

    }
    else if (y < bounds.getMinY())
    {
      y = bounds.getMinY();
      dy = -dy;
    }
  }

  private void checkBoundsX(Rectangle bounds)
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
