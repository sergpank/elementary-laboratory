package chugunov;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BallPanel extends JComponent
{
  private List<Ball> balls;

  public BallPanel(List<Ball> balls)
  {
    this.balls = balls;
    setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
  }

  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    for (Ball ball : balls)
    {
      g2d.setColor(ball.getColor());
      g2d.fill(ball.getShape());
    }
  }

  @Override
  public Dimension getPreferredSize()
  {
    return new Dimension(800, 600);
  }

}
