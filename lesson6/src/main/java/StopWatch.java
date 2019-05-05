import java.util.concurrent.TimeUnit;

public class StopWatch
{
  private long start;
  private long durationMs;

  public void start()
  {
    start = System.currentTimeMillis();
  }

  public void stop()
  {
    long stop = System.currentTimeMillis();

    durationMs = stop - start;
    start = 0;
  }

  public long getMillis()
  {
    return durationMs;
  }

  public long getSeconds()
  {
    return TimeUnit.MILLISECONDS.toSeconds(durationMs);
  }
}
