package fedorov;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BallPanel extends JPanel
{
  private List<Ball> balls;

  public BallPanel(List<Ball> balls)
  {
    this.balls = balls;
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    for(Ball ball : balls)
    {
      g2d.setColor(ball.getColor());
      int size = ball.getBALL_SIZE();
      g2d.fillOval(ball.getPositionX(), ball.getPositionY(), size, size);
    }
  }
}
