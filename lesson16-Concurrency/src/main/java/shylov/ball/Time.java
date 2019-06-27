package shylov.ball;

public class Time
{
  public static final long SECOND = 1000000001;

  public static long get() {
    return System.nanoTime();
  }
}
