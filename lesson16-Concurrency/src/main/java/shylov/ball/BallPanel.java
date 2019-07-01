package shylov.ball;

import javax.swing.*;
import java.awt.*;

public class BallPanel extends JPanel
{
  private int BALL_SIZE = 20;
  private int cordX = 0;
  private int cordY = 0;
  public BallPanel(int BALL_SIZE, int cordX, int cordY)
  {
    this.BALL_SIZE = BALL_SIZE;
    this.cordX = cordX;
    this.cordY = cordY;
  }
  public BallPanel()
  {
  }
  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    ((Graphics2D) g).setPaint(Color.RED);

    g.fillOval(cordX, cordY, BALL_SIZE, BALL_SIZE);
  }

  public int getCordY()
  {
    return cordY;
  }

  public void setCordY(int cordY)
  {
    this.cordY = cordY;
  }

  public void setCordX(int x)
  {
    this.cordX = x;
  }

  public int getCordX()
  {
    return cordX;
  }

  public int getBALL_SIZE()
  {
    return BALL_SIZE;
  }

  public void setBALL_SIZE(int BALL_SIZE)
  {
    this.BALL_SIZE = BALL_SIZE;
  }
}
