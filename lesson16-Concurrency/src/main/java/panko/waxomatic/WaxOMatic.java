package panko.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class WaxOMatic
{
  public static void main(String[] args) throws Exception
  {
    Car car = new Car();

    ExecutorService exec = Executors.newCachedThreadPool();

    exec.execute(new WaxOff(car));
    exec.execute(new WaxOn(car));

    TimeUnit.SECONDS.sleep(5); // Run for a while...
    exec.shutdownNow(); // Interrupt all tasks
  }
}
