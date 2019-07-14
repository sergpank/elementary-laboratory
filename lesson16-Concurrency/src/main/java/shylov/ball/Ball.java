package shylov.ball;

import java.awt.*;

public class Ball
{
  private int x;
  private int y;
  private int diametr;
  private int speed;
  private Direction heading;

  public Color getColor()
  {
    return color;
  }

  private Color color;

  public Ball(int x, int y, int diametr, int speed, Direction heading, Color color)
  {
    this.x = x;
    this.y = y;
    this.diametr = diametr;
    this.speed = speed;
    this.heading = heading;
    this.color = color;
  }

  public synchronized void move()
  {
    switch (heading)
    {
      case NORTH:
      {
        moveNorth();
        break;
      }
      case SOUTH:
      {
        moveSouth();
        break;
      }
      case WEST:
      {
        moveWest();
        break;
      }
      case EAST:
      {
        moveEast();
        break;
      }
      case NW:
      {
        moveNW();
        break;
      }
      case NE:
      {
        moveNE();
        break;
      }
      case SE:
      {
        moveSE();
        break;
      }
      case SW:
      {
        moveSW();
        break;
      }
    }
  }

  public void setHeading(Direction heading)
  {
    this.heading = heading;
  }

  public int getX()
  {

    return x;
  }

  public int getY()
  {
    return y;
  }

  public int getDiametr()
  {
    return diametr;
  }

  public int getSpeed()
  {
    return speed;
  }

  public Direction getHeading()
  {
    return heading;
  }

  private void moveNorth()
  {
    y -= speed;
  }

  private void moveSouth()
  {
    y += speed;
  }

  private void moveWest()
  {
    x -= speed;
  }

  private void moveEast()
  {
    x += speed;
  }

  private void moveNW()
  {
    y -= speed;
    x -= speed;
  }

  private void moveNE()
  {
    y -= speed;
    x += speed;
  }

  private void moveSE()
  {
    y += speed;
    x += speed;
  }

  private void moveSW()
  {
    y += speed;
    x -= speed;
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public void setY(int y)
  {
    this.y = y;
  }

  @Override
  public boolean equals(Object o)
  {

    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    Ball ball = (Ball) o;

    if (x != ball.x)
    {
      return false;
    }
    if (y != ball.y)
    {
      return false;
    }
    if (diametr != ball.diametr)
    {
      return false;
    }
    if (speed != ball.speed)
    {
      return false;
    }
    return heading == ball.heading;
  }

  @Override
  public int hashCode()
  {
    int result = x;
    result = 31 * result + y;
    result = 31 * result + diametr;
    result = 31 * result + speed;
    result = 31 * result + (heading != null ? heading.hashCode() : 0);
    return result;
  }

  @Override
  public String toString()
  {
    return "Ball{" +
        "color=" + color.toString() +
        '}';
  }
}
