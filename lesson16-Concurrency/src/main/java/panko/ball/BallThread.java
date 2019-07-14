package panko.ball;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class BallThread extends Thread
{
  private static final Logger log = LogManager.getLogger(BallThread.class);
  private BallPanel panel;
  private int dx = 1;

  public BallThread(BallPanel panel)
  {
    this.panel = panel;
  }

  @Override
  public void run()
  {
    while(true)
    {
      checkDx();

      log.info("x = {} ; dx = {}", panel.getX(), dx);

      panel.setPos(panel.getPos() + dx);
      panel.repaint();

      sleep();
    }
  }

  private void checkDx()
  {
    System.out.println(panel.getSize());
    if (panel.getPos() >= (panel.getSize().getWidth() - BallPanel.BALL_SIZE))
    {
      dx = -1;
    }
    else if (panel.getPos() <= 0)
    {
      dx = 1;
    }
  }

  private void sleep()
  {
    try
    {
      TimeUnit.MILLISECONDS.sleep(1);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
