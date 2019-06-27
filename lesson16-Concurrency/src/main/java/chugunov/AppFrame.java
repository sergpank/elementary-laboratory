package chugunov;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppFrame extends JFrame
{
  private List<Ball> ballsSrc;
  private List<Ball> balls;
  private JComponent ballPanel;
  private JButton btnAdd;
  private JButton btnClose;
  private Object lock;
  private int cnt;
  boolean stop;

  public AppFrame() throws HeadlessException
  {
    balls = new ArrayList<>();
    lock = new Object();
    ballsSrc = setBallsSrc();

    setTitle("Шарики-Потоки");

    init();
    pack();
    setHandlers();
  }

  private void init()
  {
    ballPanel = new BallPanel(balls);

    add(ballPanel, BorderLayout.CENTER);

    JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    btnAdd = new JButton("Add ball");

    btnClose = new JButton("Close");
    btnPanel.add(btnAdd);

    btnPanel.add(btnClose);

    add(btnPanel, BorderLayout.SOUTH);
  }

  private void setHandlers()
  {
    btnAdd.addActionListener(e -> {
      Ball ball = ballsSrc.get(cnt);
      addBall(ball);
      cnt++;
      if (cnt == ballsSrc.size())
      {
        btnAdd.setEnabled(false);
      }
    });

    btnClose.addActionListener(e -> {
      System.exit(0);
    });
  }

  private void addBall(Ball ball)
  {
    balls.add(ball);

    Runnable r = () -> {
      try
      {
        while (true)
        {
          synchronized (lock)
          {
            if(stop)
            {
              wait();
            }
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

  private List<Ball> setBallsSrc()
  {
    List<Ball> src = new ArrayList<>();
    src.add(new Ball(0, 0, 1, 100, Color.RED));
    src.add(new Ball(0, 0, 2, 90, Color.ORANGE));
    src.add(new Ball(0, 0, 3, 80, Color.YELLOW));
    src.add(new Ball(0, 0, 4, 70, Color.GREEN));
    src.add(new Ball(0, 0, 5, 60, Color.CYAN));
    src.add(new Ball(0, 0, 6, 50, Color.BLUE));
    src.add(new Ball(0, 0, 7, 40, Color.MAGENTA));

    return src;
  }

}
