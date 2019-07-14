package panko.ball;

import javax.swing.*;
import java.awt.*;

public class BallPanel extends JPanel
{
  public static final int BALL_SIZE = 50;
  private int pos = 0;

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    ((Graphics2D) g).setPaint(Color.RED);
    g.fillOval(pos, 100, BALL_SIZE, BALL_SIZE);
  }

  public void setPos(int x)
  {
    this.pos = x;
  }

  public int getPos()
  {
    return pos;
  }
}
