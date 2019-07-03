package fedorov;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel
{
  public int BALL_SIZE;
  private static int ballCount = 0;
  private int positionX = 0;
  private int positionY = 0;
  private Color color;

  public Ball()
  {
    switch(ballCount)
    {
      case 0: color = Color.RED; BALL_SIZE = 50;  break;
      case 1: color = Color.GREEN; BALL_SIZE = 40; break;
      case 2: color = Color.BLUE; BALL_SIZE = 70; break;
      case 3: color = Color.YELLOW; BALL_SIZE = 10; break;
      case 4: color = Color.MAGENTA; BALL_SIZE = 80; break;
      default: break;
    }
    ballCount++;
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    ((Graphics2D) g).setPaint(color);
    g.fillOval(positionX, positionY, BALL_SIZE, BALL_SIZE);
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
}
