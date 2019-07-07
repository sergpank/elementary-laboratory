package fedorov;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel
{
  public int BALL_SIZE;
  private int positionX = 0;
  private int positionY = 0;
  private Color color;
  private int speed;

  public Ball(int x, int y, int speed, int size, Color color)
  {
    this.BALL_SIZE = size;
    this.positionX = x;
    this.positionY = y;
    this.color = color;
    this.speed = speed;
  }

  public int getBALL_SIZE()
  {
    return BALL_SIZE;
  }

  public void setBALL_SIZE(int BALL_SIZE)
  {
    this.BALL_SIZE = BALL_SIZE;
  }

  public int getPositionX()
  {
    return positionX;
  }

  public void setPositionX(int positionX)
  {
    this.positionX = positionX;
  }

  public int getPositionY()
  {
    return positionY;
  }

  public void setPositionY(int positionY)
  {
    this.positionY = positionY;
  }

  public Color getColor()
  {
    return color;
  }

  public void setColor(Color color)
  {
    this.color = color;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void setSpeed(int speed)
  {
    this.speed = speed;
  }
}
