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
  private int moveDX = 1;
  private int moveDY = 1;
  private int centerX;
  private int centerY;

  public Ball(int speed, int size, Color color)
  {
    this.BALL_SIZE = size;
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

  public int getMoveDX()
  {
    return moveDX;
  }

  public void setMoveDX(int moveDX)
  {
    this.moveDX = moveDX;
  }

  public int getMoveDY()
  {
    return moveDY;
  }

  public void setMoveDY(int moveDY)
  {
    this.moveDY = moveDY;
  }

  public int getCenterX()
  {
    return centerX;
  }

  public void setCenterX(int centerX)
  {
    this.centerX = centerX;
  }

  public int getCenterY()
  {
    return centerY;
  }

  public void setCenterY(int centerY)
  {
    this.centerY = centerY;
  }

  public Ball changeMoveDX()
  {
    if(moveDX == 1)
    {
      moveDX = -1;
    }
    else if(moveDX == -1)
    {
      moveDX = 1;
    }
    return this;
  }

  public Ball changeMoveDY()
  {

    if(moveDY == 1)
    {
      moveDY = -1;
    }
    else if(moveDY == -1)
    {
      moveDY = 1;
    }
    return this;
  }
}
