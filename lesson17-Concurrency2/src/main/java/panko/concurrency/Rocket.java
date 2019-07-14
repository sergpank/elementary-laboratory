package panko.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Rocket implements Runnable
{
  private static final Logger log = LogManager.getLogger(Rocket.class);

  private int cnt;
  private long delay;
  private TimeUnit unit;

  public Rocket(int cnt, long delay, TimeUnit unit)
  {
    this.cnt = cnt;
    this.delay = delay;
    this.unit = unit;
  }

  @Override
  public void run()
  {
    log.info("До пуска осталось : ");
    for (int i = cnt; i > 0; i--)
    {
      log.info(i);
      sleep();
      Thread.yield();
    }
    log.info("Поехали!");
  }

  private void sleep()
  {
    try
    {
      unit.sleep(delay);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
