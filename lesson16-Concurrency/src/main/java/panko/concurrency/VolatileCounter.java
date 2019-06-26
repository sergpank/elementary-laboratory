package panko.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileCounter
{
  private static final Logger log = LogManager.getLogger(VolatileCounter.class);
  long cnt = 0;

  Object lock = new Object();

  public static void main(String[] args) throws InterruptedException
  {
    new VolatileCounter().test();

  }

  private void test() throws InterruptedException
  {
    Thread[] pool = new Thread[10];

    for (int i = 0; i < 10; i++)
    {
      CntThread cntThread = new CntThread();
      cntThread.start();
      pool[i] = cntThread;
    }

    for (Thread t : pool)
    {
      try
      {
        t.join();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

//      ExecutorService pool = Executors.newFixedThreadPool(10);
//      for (int i = 0; i < 10; i++)
//      {
//        pool.submit(new CntThread());
//      }
//
//      pool.shutdown();
//      pool.awaitTermination(1, TimeUnit.SECONDS);

      log.info("cnt = {}", cnt);
  }

  class CntThread extends Thread
  {
    @Override
    public void run()
    {
      log.info("start");
      for (int i = 0; i < 1000_000; i++)
      {
        synchronized (lock)
        {
          cnt++;
        }
      }
      log.info("end : {}", cnt);
    }
  }
}
