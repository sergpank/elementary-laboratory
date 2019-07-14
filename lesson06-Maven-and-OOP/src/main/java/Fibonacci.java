public class Fibonacci
{
  private long callCnt;

  public long recursive(int f)
  {
    callCnt++;
    if (f == 0)
    {
      return 0;
    }
    if (f == 1)
    {
      return 1;
    }
    return recursive(f - 1) + recursive( f - 2);
  }

  public long iterative(int f)
  {
    long f0 = 0;
    long f1 = 1;
    long fibonacci = -1;

    if (f == 0)
    {
      return f0;
    }
    if (f == 1)
    {
      return f1;
    }

    for (int i = 2; i <= f; i++)
    {
      fibonacci = f0 + f1;
      f0 = f1;
      f1 = fibonacci;
    }

    return fibonacci;
  }

  public static void main(String[] args)
  {
    Fibonacci fibonacci = new Fibonacci();
    StopWatch sw = new StopWatch();

    for (int i = 0; i <= 47; i++)
    {
      fibonacci.callCnt = 0;

      sw.start();
      long recursive = fibonacci.recursive(i);
      sw.stop();
      long recursiveDuration = sw.getMillis();

      sw.start();
      long iterative = fibonacci.iterative(i);
      sw.stop();
      long iterativeDuration = sw.getMillis();

      System.out.printf("%2d :: recursive - %d (%d ms) calls : %d\n", i, recursive, recursiveDuration, fibonacci.callCnt);
      System.out.printf("%2d :: iterative - %d (%d ms)\n\n", i, iterative, iterativeDuration);
    }
  }
}
