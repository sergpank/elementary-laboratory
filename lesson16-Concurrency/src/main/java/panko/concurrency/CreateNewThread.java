package panko.concurrency;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class CreateNewThread
{
  private static final Logger log = LogManager.getLogger(CreateNewThread.class);

  public static void main(String[] args) throws InterruptedException
  {
    log.info("START");
//    ChickenThread chicken = new ChickenThread();
//    EggThread egg = new EggThread();

    Thread thread = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        int i = 0;
        while(true)
        {
          log.info(i++ + " :: Chicken!");
          try
          {
            Thread.sleep(100);
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }
          if (i > 50)
          {
            break;
          }
        }
      }
    });

    thread.start();
    thread.join();

    TimeUnit.SECONDS.sleep(5);

    log.info("END");
  }
}
