package fedorov;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class BallThread extends  Thread
{
  public Ball ball;
  public JPanel ballPanel;
  private int moveDX = 1;

  public BallThread(Ball ball, JPanel ballPanel)
  {
   this.ball = ball;
   this.ballPanel = ballPanel;
  }

  @Override
  public void run()
  {
    while(true)
    {
      checkDirection();

      ball.setPositionX(ball.getPositionX() + moveDX);
      ballPanel.repaint();
      sleep();
    }
  }

  private void checkDirection()
  {
    if(ball.getPositionX() >= ballPanel.getSize().getWidth() - ball.BALL_SIZE)
    {
      moveDX = -1;
    }
    else if(ball.getPositionX() <= 0)
    {
      moveDX = 1;
    }
  }

  private void sleep()
  {
    try
    {
      TimeUnit.MILLISECONDS.sleep(11 - ball.getSpeed());
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
