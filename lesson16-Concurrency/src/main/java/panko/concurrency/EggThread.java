package panko.concurrency;

import java.util.concurrent.TimeUnit;

public class EggThread extends Thread
{
  @Override
  public void run()
  {
    for (int i = 0; i < 10; i++)
    {
      System.out.println(i + " :: Egg!");

      try
      {
        TimeUnit.MILLISECONDS.sleep(100);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
