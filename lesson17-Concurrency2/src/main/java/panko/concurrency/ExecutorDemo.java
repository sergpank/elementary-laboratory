package panko.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo
{
  private static final Logger log = LogManager.getLogger();

  public static void main(String[] args) throws InterruptedException
  {
    log.info("STRT");

    int cpuNr = Runtime.getRuntime().availableProcessors();
    log.info("Available processors = {}", cpuNr);

//    ExecutorService executor = Executors.newSingleThreadExecutor();
//    ExecutorService executor = Executors.newFixedThreadPool(cpuNr);
    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 0; i < 40; i++)
    {
      Rocket task = new Rocket(10, 1, TimeUnit.SECONDS);
      executor.execute(task);
    }

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.HOURS);

    log.info("END");
  }
}
