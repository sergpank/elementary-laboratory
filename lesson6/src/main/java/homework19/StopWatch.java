package homework19;

import java.util.concurrent.TimeUnit;

public class StopWatch
{
  private long start;
  private long duration;

  public void start()
  {
    start = System.nanoTime();
  }

  public void stop()
  {
    long stop = System.nanoTime();
    duration = stop - start;
    start = 0;
  }

  public long getSeconds()
  {
    return TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
  }

  public long getMilliseconds()
  {
    return TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS);
  }

  public long getMicroseconds()
  {
    return TimeUnit.MICROSECONDS.convert(duration, TimeUnit.NANOSECONDS);
  }

  public long getNanoseconds()
  {
    return duration;
  }
}