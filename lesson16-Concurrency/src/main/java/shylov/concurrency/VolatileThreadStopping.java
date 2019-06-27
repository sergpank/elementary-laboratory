package shylov.concurrency;

public class VolatileThreadStopping extends Thread
{
  volatile boolean keepRunning = true;

  public void run()
  {
    while(keepRunning)
    {
      System.out.println("Running ...");
    }

    System.out.println("Thread terminated.");
  }

  public static void main(String[] args) throws InterruptedException
  {
    VolatileThreadStopping t = new VolatileThreadStopping();
    t.start();
    Thread.sleep(1000);
    System.out.println("keepRunning set to false.");
    t.keepRunning = false;
  }
}