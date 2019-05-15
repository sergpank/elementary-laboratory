package homework19;

public class Factorial
{
  private static long numberCalls;

  public static void main(String[] args)
  {
    long durationRc;
    long durationIter;
    long val1;
    long val2;
    long nCalls;
    int number = 18;

    StopWatch t = new StopWatch();
    numberCalls = 0;
    t.start();
    val1 = getFactorialRc(number);
    t.stop();
    nCalls = numberCalls;
    durationRc = t.getMicroseconds();
    t.start();
    val2 = getFactorialIter(number);
    t.stop();
    durationIter = t.getMicroseconds();

    System.out.printf("Факториал числа %d:\n" +
            "Рекурсивный метод - значение: %d, длительность %d микросекунд, количество вызовов %d;\n" +
            "Итеративный метод - значение: %d, длительность %d микросекунд;\n\n",
        number, val1, durationRc, nCalls, val2, durationIter);
  }

    /*
        Факториал числа 18:
        Рекурсивный метод - значение: 6402373705728000, длительность 15 микросекунд, количество вызовов 19;
        Итеративный метод - значение: 6402373705728000, длительность 7 микросекунд;

    */

  public static long getFactorialRc(int number)
  {
    long result = 1;

    if (number > 0)
    {
      result = number * getFactorialRc(number - 1);
    }
    numberCalls++;

    return result;
  }

  public static long getFactorialIter(int number)
  {
    long result = 1;

    if (number > 1)
    {
      for (int i = 2; i <= number; i++)
      {
        result *= i;
      }
    }
    return result;
  }
} 
