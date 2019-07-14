package panko.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class InterruptSleep
{
  private static final Logger log = LogManager.getLogger(InterruptSleep.class);

  public static void main(String[] args) throws InterruptedException
  {
    log.info("start");
    Thread thread = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          log.info("start");
          TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    });

    thread.start();

    TimeUnit.SECONDS.sleep(3);
    thread.interrupt();
    log.info("stop");
  }
}
