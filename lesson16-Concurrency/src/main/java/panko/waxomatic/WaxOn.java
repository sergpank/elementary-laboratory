package panko.waxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable
{
  private Car car;

  public WaxOn(Car c)
  {
    car = c;
  }

  public void run()
  {
    try
    {
      while (!Thread.interrupted())
      {
        Logger.log("Wax On! ");
        TimeUnit.MILLISECONDS.sleep(200);
        car.waxed();
        car.waitForBuffing();
      }
    }
    catch (InterruptedException e)
    {
      Logger.log("Exiting via interrupt");
    }
    Logger.log("Ending Wax On task");
  }
}
