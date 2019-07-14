package panko.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class InterruptLoop
{
  private static final Logger log = LogManager.getLogger(InterruptLoop.class);

  public static void main(String[] args) throws InterruptedException
  {
    log.info("start");
    Thread thread = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        int cnt = 0;
        while( ! Thread.currentThread().interrupted())
        {
          log.info(cnt++);
        }
        log.info(Thread.currentThread().isInterrupted());
      }
    });

    thread.start();

    TimeUnit.SECONDS.sleep(3);
    thread.stop();
    log.info("stop");
  }
}
