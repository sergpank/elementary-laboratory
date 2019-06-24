package panko.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolatileCounter
{
  private static final Logger log = LogManager.getLogger(VolatileCounter.class);
  long cnt = 0;

  Object lock = new Object();

  public static void main(String[] args)
  {
    new VolatileCounter().test();

  }

  private void test()
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

    log.info("cnt = {}", cnt);
  }

  class CntThread extends Thread
  {
    public void run()
    {
      log.info("start");
      for (int i = 0; i < 1000_000; i++)
      {
//        synchronized(lock)
//        {
//          cnt = cnt + 1;
//        }
        cnt++;
      }
      log.info("end : {}", cnt);
    }
  }
}
