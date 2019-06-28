package panko.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo
{
  public static void main(String[] args) throws InterruptedException, ExecutionException
  {
    ExecutorService pool = Executors.newCachedThreadPool();
    List<Future<Long>> results = new ArrayList<>();

    for (int i = 0; i < 10; i++)
    {
      results.add(pool.submit(new Counter(1L, 1000L)));
    }

    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.HOURS);

    for (Future<Long> f : results)
    {
      System.out.println(f.get());
    }
  }
}
