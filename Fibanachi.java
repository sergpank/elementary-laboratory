package hillel.lesson5;

public class Fibanachi
{
  public static void main(String[] args)
  {
    long timestart = System.currentTimeMillis();
    System.out.println("45 число Фибаначи: " + fibonacci(45));
    long timeend = System.currentTimeMillis();
    System.out.println("время поиска: " + (timeend - timestart) + "ms");

    timestart = System.currentTimeMillis();
    System.out.println("46 число Фибаначи: " + fibonacci(46));
    timeend = System.currentTimeMillis();
    System.out.println("время поиска: " + (timeend - timestart) + "ms");

    timestart = System.currentTimeMillis();
    System.out.println("47 число Фибаначи: " + fibonacci(47));
    timeend = System.currentTimeMillis();
    System.out.println("время поиска: " + (timeend - timestart) + "ms");
  }

  public static long fibonacci(int f)
  {
    if (f == 0)
    {
      return 0;
    }
    else if (f == 1)
    {
      return 1;
    }
    else
    {
      return fibonacci(f - 1) + fibonacci(f - 2);
    }
  }
}
