package zhuravlov.ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppFrame extends JFrame
{
  private JComponent ballPanel;
  private Object lock;
  private List<Ball> balls;

  public AppFrame() throws HeadlessException
  {
    balls = new ArrayList<>();
    balls.add(new Ball(0, 0, 3, 20, Color.RED));
    balls.add(new Ball(40, 40, 2, 40, Color.GREEN));
    balls.add(new Ball(160, 160, 1, 60, Color.BLUE));
    lock = new Object();
    init();
    pack();
    for (Ball b : balls)
    {
      moving(b);
    }

  }


  private void init()
  {
    ballPanel = new BallPanel(balls);

    add(ballPanel, BorderLayout.CENTER);

    JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    add(btnPanel, BorderLayout.SOUTH);
  }

  private void moving(Ball ball)
  {

    Runnable r = () -> {
      try
      {
        while (true)
        {
          synchronized (lock)
          {
            ball.move(ballPanel.getBounds(), balls);
            ballPanel.repaint();

          }
          TimeUnit.MILLISECONDS.sleep(5);
        }
      }
      catch (InterruptedException e)
      {

      }
    };
    Thread t = new Thread(r);
    t.setDaemon(true);
    t.start();
  }

}
