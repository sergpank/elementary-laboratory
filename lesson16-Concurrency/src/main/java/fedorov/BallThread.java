package fedorov;

import java.util.concurrent.TimeUnit;

public class BallThread extends  Thread
{
  public Ball ball;
  private int moveDX = 1;
  private int moveDY = -1;

  public BallThread(Ball ball)
  {
   this.ball = ball;
  }

  @Override
  public void run()
  {
    while(true)
    {
      checkDirection();

      ball.setPositionX(ball.getPositionX() + moveDX);
      ball.setPositionY(ball.getPositionY() + moveDY);
      ball.repaint();

      sleep();
    }
  }

  private void checkDirection()
  {
    if(ball.getPositionX() >= ball.getSize().getWidth() - ball.BALL_SIZE)
    {
      moveDX = -1;
    }
    else if(ball.getPositionX() <= 0)
    {
      moveDX = 1;
    }

    if(ball.getPositionY() >= ball.getSize().getHeight() - ball.BALL_SIZE)
    {
      moveDY = -1;
    }
    else if(ball.getPositionY() <= 0)
    {
      moveDY = 1;
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
