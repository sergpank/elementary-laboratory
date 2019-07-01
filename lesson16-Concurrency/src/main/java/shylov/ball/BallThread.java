package shylov.ball;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BallThread extends Thread
{
  private static final Logger log = LogManager.getLogger(BallThread.class);
  private Ball ball;
  private Checker checker;
  private BallPanel ballPanel;


  public BallThread(BallPanel ballPanel,Checker checker,Ball ball)
  {
    this.ball = ball;
    this.ballPanel = ballPanel;
    this.checker = checker;
  }

  @Override
  public void run()
  {
    while(true)
    {
      if (checker.check(ball)){
        ball.move();
        ballPanel.repaint();
      }else {
        if (ball.getHeading().getNumeric() < Direction.values().length - 1){
          ball.setHeading(Direction.values()[ball.getHeading().getNumeric()+1]);
        }else {
          ball.setHeading(Direction.values()[0]);
        }
      }
      sleep();
    }
  }



  private void sleep()
  {
    try
    {
      TimeUnit.MILLISECONDS.sleep(4);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
