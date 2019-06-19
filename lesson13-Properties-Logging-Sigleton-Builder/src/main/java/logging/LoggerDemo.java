package logging;

import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;

public class LoggerDemo
{
    private static final org.apache.logging.log4j.Logger log4j2 = LogManager.getLogger(LoggerDemo.class);

    private static final org.slf4j.Logger slf4j = LoggerFactory.getLogger(LoggerDemo.class);

    public static void main(String[] args)
    {
        log4j2.trace("Log4j2");
        log4j2.debug("Log4j2");
        log4j2.info("Log4j2");
        log4j2.warn("Log4j2");
        log4j2.error("Log4j2");

        System.out.println();

        slf4j.trace("SLF4J");
        slf4j.debug("SLF4J");
        slf4j.info("SLF4J");
        slf4j.warn("SLF4J");
        slf4j.error("SLF4J");
    }
}
