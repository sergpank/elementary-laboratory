package panko.waxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable
{
  private Car car;

  public WaxOff(Car c)
  {
    car = c;
  }

  public void run()
  {
    try
    {
      while (!Thread.interrupted())
      {
        car.waitForWaxing();
        Logger.log("Wax Off! ");
        TimeUnit.MILLISECONDS.sleep(200);
        car.buffed();
      }
    }
    catch (InterruptedException e)
    {
      Logger.log("Exiting via interrupt");
    }
    Logger.log("Ending Wax Off task");
  }
}
