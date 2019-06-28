package panko.concurrency;

import java.util.concurrent.Callable;

public class Counter implements Callable<Long>
{
  private long from;
  private long to;

  public Counter(long from, long to)
  {
    this.from = from;
    this.to = to;
  }

  @Override
  public Long call() throws Exception
  {
    long result = 0;

    for (long value = from; value <= to; value++)
    {
      result += value;
    }

    return result;
  }
}
