package panko.concurrency;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterruptSleep
{
    private static final Logger log = LogManager.getLogger(InterruptSleep.class);

    public static void main(String[] args)
    {
        final InterruptSleep demo = new InterruptSleep();
        demo.show();
    }

    void show()
    {
        Thread sleepThread = createSleepThread();
        sleepThread.start();

        log.info("fast sleep for 3 seconds ...");
        sleep(TimeUnit.SECONDS, 3);
        log.info("fast sleep is over");

        sleepThread.interrupt();
    }

    private Thread createSleepThread()
    {
        return new Thread(new Runnable() {
            @Override public void run()
            {
                long duration = 1;
                log.info("Long Sleep for {} minutes ...", duration);
                sleep(TimeUnit.MINUTES, duration);
                log.info("Long Sleep for {} minutes is over!", duration);
            }
        });
    }

    private void sleep(TimeUnit unit, long duration)
    {
        try
        {
            unit.sleep(duration);
        }
        catch (InterruptedException e)
        {
            log.error("Sleep was interrupted!", e);
        }
    }
}
