package shylov.ball;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class BallPanel extends JPanel
{
  private List<Ball> balls;

  public BallPanel( List<Ball> balls)
  {
    this.balls = balls;

  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    for (Ball ball:balls)
    {
      g.fillOval(ball.getX(),ball.getY(),ball.getDiametr(),ball.getDiametr());
    }

  }
}
