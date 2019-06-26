package panko.concurrency;

public class ChickenThread extends Thread
{
  @Override
  public void run()
  {
    for (int i = 0; i < 10; i++)
    {
      System.out.println(i + " :: Chicken!");
      try
      {
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
