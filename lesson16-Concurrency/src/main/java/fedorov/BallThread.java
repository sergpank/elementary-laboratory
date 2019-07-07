package fedorov;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BallThread extends  Thread
{
  private Ball ball;
  private JPanel ballPanel;
  private List<Ball> balls;

  public BallThread(Ball ball, JPanel ballPanel, List<Ball> balls)
  {
   this.ball = ball;
   this.ballPanel = ballPanel;
   this.balls = balls;
  }

  @Override
  public void run()
  {
    while(true)
    {
      checkDirection();
      ball.setPositionX(ball.getPositionX() + ball.getMoveDX());
      ball.setPositionY(ball.getPositionY() + ball.getMoveDY());
      ballPanel.repaint();
      sleep();
    }
  }

  private void checkDirection()
  {
    if(ball.getPositionX() >= ballPanel.getSize().getWidth() - ball.BALL_SIZE)
    {
      ball.setMoveDX(-1);
    }
    else if(ball.getPositionX() <= 0)
    {
      ball.setMoveDX(1);
    }

      for (int i = 0; i < balls.size(); i++)
      {
        if(! (balls.indexOf(ball) == i))
        {
          // тут должна была быть обработка столкновений
        }
      }


    if(ball.getPositionY() >= ballPanel.getSize().getHeight() - ball.BALL_SIZE)
    {
      ball.setMoveDY(-1);
    }
    else if(ball.getPositionY() <= 0)
    {
      ball.setMoveDY(1);
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

  private void changeMoveDX()
  {
    if(ball.getMoveDX() == 1)
    {
      ball.setMoveDX(-1);
      return;
    }

    if(ball.getMoveDX() == -1)
    {
      ball.setMoveDX(1);
      return;
    }
  }

  private void changeMoveDY()
  {
    if(ball.getMoveDY() == 1)
    {
      ball.setMoveDY(-1);
      return;
    }

    if(ball.getMoveDY() == -1)
    {
      ball.setMoveDY(1);
      return;
    }
  }

}
