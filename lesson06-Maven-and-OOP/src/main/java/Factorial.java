public class Factorial
{
  public long recursive(long i)
  {
    if (i <= 1)
    {
      return 1;
    }
    else
    {
      return i * recursive(--i);
    }
  }

  public long iterative(long i)
  {
    long result = 1;
    while (i > 1)
    {
      result *= i--;
    }

    return result;
  }

  public static void main(String[] args)
  {
    for (int i = 0; i < 21; i++)
    {
      Factorial factorial = new Factorial();

      long recursive = factorial.recursive(i);
      long iterative = factorial.iterative(i);

      System.out.printf("%2d :: recursive - %d\n", i, recursive);
      System.out.printf("%2d :: iterative - %d\n\n", i, iterative);
    }
  }
}
