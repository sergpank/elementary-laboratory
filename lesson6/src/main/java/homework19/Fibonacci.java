package homework19;

public class Fibonacci
{
  private static long numberCalls;

  public static void main(String[] args)
  {
    long durationRc1;
    long durationRc2;
    long durationIter;
    long nCalls1;
    long nCalls2;
    long member1;
    long member2;
    long member3;
    StringBuilder report = new StringBuilder();


    StopWatch t = new StopWatch();

    for (int n = 45; n <= 47; n++)
    {
      t.start();
      member1 = getNumRc(n);
      t.stop();
      durationRc1 = t.getMilliseconds();
      nCalls1 = numberCalls;

      t.start();
      member2 = getNumRcCached(n);
      t.stop();
      durationRc2 = t.getMicroseconds();
      nCalls2 = numberCalls;

      t.start();
      member3 = getNumIteratively(n);
      t.stop();
      durationIter = t.getMicroseconds();
      nCalls2 = numberCalls;

      String str = String.format("Вычисление %d-го члена ряда Фибоначчи:\n" +
              "Рекурсивный метод, значение %d, количество вызовов метода %d, длительность %d миллисекуд;\n" +
              "Оптимизированный рекурсивный метод, значение %d, " +
              "количество вызовов метода %d, длительность %d микросекунд;\n" +
              "Итеративный метод, значение %d, длительность %d микросекунд;\n\n", n,
          member1, nCalls1, durationRc1, member2, nCalls2, durationRc2, member3, durationIter);

      report.append(str);
    }

    System.out.println(report);
  }

    /*
        Пример вывода:
        
       Вычисление 45-го члена ряда Фибоначчи:
       Рекурсивный метод, значение 1134903170, количество вызовов метода 3672623805, длительность 21350 миллисекуд;
       Оптимизированный рекурсивный метод, значение 1134903170, количество вызовов метода 89, длительность 29 микросекунд;
       Итеративный метод, значение 1134903170, длительность 6 микросекунд;

       Вычисление 46-го члена ряда Фибоначчи:
       Рекурсивный метод, значение 1836311903, количество вызовов метода 5942430145, длительность 34803 миллисекуд;
       Оптимизированный рекурсивный метод, значение 1836311903, количество вызовов метода 91, длительность 46 микросекунд;
       Итеративный метод, значение 1836311903, длительность 4 микросекунд;

       Вычисление 47-го члена ряда Фибоначчи:
       Рекурсивный метод, значение 2971215073, количество вызовов метода 9615053951, длительность 56326 миллисекуд;
       Оптимизированный рекурсивный метод, значение 2971215073, количество вызовов метода 93, длительность 62 микросекунд;
       Итеративный метод, значение 2971215073, длительность 5 микросекунд;


    */

  public static long getNumRc(int n)
  {
    numberCalls = 0;

    return getNumRecursively(n);
  }

  public static long getNumRcCached(int n)
  {
    long[] cache = new long[n + 1];
    numberCalls = 0;

    return getNumRecursively(n, cache);
  }

  private static long getNumRecursively(int n)
  {
    long num = 0;
    if (n == 1)
    {
      num = 1;
    }
    else if (n >= 2)
    {
      long prev1 = getNumRecursively(n - 1);
      long prev2 = getNumRecursively(n - 2);
      num = prev1 + prev2;
    }
    numberCalls++;

    return num;
  }

  private static long getNumRecursively(int n, long[] cache)
  {
    if (cache[n] == 0 && n != 0)
    {
      if (n == 1)
      {
        cache[n] = 1;
      }
      else if (n >= 2)
      {
        long prev1 = getNumRecursively(n - 1, cache);
        long prev2 = getNumRecursively(n - 2, cache);
        cache[n] = prev1 + prev2;
      }
    }
    numberCalls++;

    return cache[n];
  }

  public static long getNumIteratively(int n)
  {
    long prev1 = 0;
    long prev2 = 1;

    long num = 0;
    if (n == 1)
    {
      num = 1;
    }
    else if (n >= 2)
    {
      for (int i = 2; i <= n; i++)
      {
        num = prev1 + prev2;
        prev1 = prev2;
        prev2 = num;
      }
    }

    return num;
  }
}