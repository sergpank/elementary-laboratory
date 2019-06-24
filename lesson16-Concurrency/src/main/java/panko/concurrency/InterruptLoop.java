package panko.concurrency;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterruptLoop
{
    private static final Logger log = LogManager.getLogger(InterruptLoop.class);

    public static void main(String[] args)
    {
        final InterruptLoop interruptLoop = new InterruptLoop();

        Thread thread = interruptLoop.createThread();
        thread.start();

        log.debug("Interrupting thread ...");
        thread.interrupt();
        log.debug("Thread is interrupted : {}", thread.isInterrupted());
        log.debug("Thread is interrupted : {}", thread.isInterrupted());
        log.debug("Thread is interrupted : {}", thread.isInterrupted());
        log.debug("Thread is interrupted : {}", thread.isInterrupted());
        log.debug("Thread is interrupted : {}", thread.isInterrupted());
    }

    Thread createThread()
    {
        return new Thread(new Runnable() {
            @Override public void run()
            {
                for (int i = 0; i < 1000; i++)
                {
                    log.debug(i);
                }
            }
        });
    }
}
