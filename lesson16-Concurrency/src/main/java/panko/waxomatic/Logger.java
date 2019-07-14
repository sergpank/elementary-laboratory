package panko.waxomatic;

public class Logger
{
  private static long start = System.currentTimeMillis();

  public static void log(String msg)
  {
    System.out.printf("%5d :: %s\n", System.currentTimeMillis() - start, msg);
  }
}
