package hillel.lesson5;

public class Factorial
{
  public static void main(String[] args)
  {
    Fact(5);
  }

  public static long Fact(int f)
  {
    long fact;
    if (f == 0 || f == 1)
    {
      System.out.println(f + " факториал -> " + 1);
      return 1;
    }
    fact = f * Fact(f - 1);
    System.out.println(fact + " факториал -> " + f);
    return fact;
  }
}
