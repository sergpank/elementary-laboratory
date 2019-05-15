package homework19;

public class Pascal
{
  private static long callsNumber = 0;

  public static void main(String[] args)
  {
    long durationRc;
    long durationRcCached;
    long durationIter;
    long durationVis;
    long numberCalls1;
    long numberCalls2;

    StopWatch t = new StopWatch();
    int depth = 20;
    long[] pascalData = null;

    t.start();
    pascalData = buildRecursively(depth);
    t.stop();
    numberCalls1 = callsNumber;
    durationRc = t.getMicroseconds();
    System.out.println();
    display(pascalData);
    t.start();
    pascalData = buildUsingCache(depth);
    t.stop();
    numberCalls2 = callsNumber;
    durationRcCached = t.getMicroseconds();
    display(pascalData);
    t.start();
    pascalData = buildIteratively(depth);
    t.stop();
    durationIter = t.getMicroseconds();
    t.start();
    display(pascalData);
    t.stop();
    durationVis = t.getMicroseconds();

    String report = String.format("\nThe depth of the Pascal's triangle - %d;\n" +
            "\nSimple recursive method - duration %d microseconds, number of calls - %d;\n" +
            "\nRecursive method with optimization - duration %d microseconds, number of calls - %d;\n" +
            "\nIterative method - duration %d microseconds;\n" +
            "\nDisplay method - duration %d microseconds;\n",
        depth, durationRc, numberCalls1, durationRcCached, numberCalls2, durationIter, durationVis);

    System.out.println(report);
  }

  /*-----------Рекурсивное построение треугольника Паскаля--------------------------------------*/


  /**
   * Метод получает значения для треугольника Паскаля рекурсивно
   *
   * @param depth задает глубину рассчета треугольника Паскаля
   * @return массив значений  треугольника Паскаля
   */
  public static long[] buildRecursively(int depth)
  {
    long[] pascalData = new long[getSum(depth)];

    callsNumber = 0;

    for (int i = 0; i < depth; i++)
    {
      for (int j = 0; j <= i; j++)
      {
        pascalData[getIndex(i, j)] = getNumRecursively(i, j);
      }
    }

    return pascalData;
  }

  /**
   * Метод рекурсивно получает значение числа, находящегося на пересечении
   * определенного столбца и строки треугольника Паскаля
   *
   * @param row номер строки треугольника Паскаля, начиная с нуля
   * @param col номер столбца треугольника Паскаля, начиная с нуля
   * @return значение числа, находящегося на пересечении
   * определенного столбца и строки треугольника Паскаля
   */
  private static long getNumRecursively(int row, int col)
  {
    long result = 0;

    if (col == 0 || col == row)
    {
      result = 1;
    }
    else
    {
      long left = getNumRecursively(row - 1, col - 1);
      long right = getNumRecursively(row - 1, col);
      result = left + right;
    }
    callsNumber++;

    return result;
  }

  /*-----------Оптимизированное рекурсивное построение треугольника Паскаля ---------*/

  /**
   * Метод получает значения для треугольника Паскаля рекурсивно с запоминанием вычисленных значений
   *
   * @param depth задает глубину рассчета треугольника Паскаля
   * @return массив значений  треугольника Паскаля
   */
  public static long[] buildUsingCache(int depth)
  {
    long[] cache = new long[getSum(depth)];
    callsNumber = 0;

    for (int i = 0; i < depth; i++)
    {
      for (int j = 0; j <= i; j++)
      {
        getNumUsingCache(i, j, cache);
      }
    }

    return cache;
  }

  /**
   * Метод рекурсивно получает значение числа, находящегося на пересечении
   * определенного столбца и строки треугольника Паскаля
   *
   * @param row   номер строки треугольника Паскаля, начиная с нуля
   * @param col   номер столбца треугольника Паскаля, начиная с нуля
   * @param cache массив, в котором сохраняется полученное значение
   * @return значение числа, находящегося на пересечении
   * определенного столбца и строки треугольника Паскаля
   */
  private static long getNumUsingCache(int row, int col, long[] cache)
  {
    int index = getIndex(row, col);

    if (cache[index] == 0)
    {
      if (col == 0 || col == row)
      {
        cache[index] = 1;
      }
      else
      {
        long left = getNumUsingCache(row - 1, col - 1, cache);
        long right = getNumUsingCache(row - 1, col, cache);
        cache[index] = left + right;
      }
    }
    callsNumber++;

    return cache[index];
  }

  /*-------------Итеративное построение треугольника Паскаля-------------------------------------*/

  /**
   * Метод получает значения для треугольника Паскаля итеративно
   *
   * @param depth задает глубину рассчета треугольника Паскаля
   * @return массив значений  треугольника Паскаля
   */
  public static long[] buildIteratively(int depth)
  {
    long[] pascalData = new long[getSum(depth)];

    for (int i = 0; i < depth; i++)
    {
      for (int j = 0; j <= i; j++)
      {
        getNumIteratively(i, j, pascalData);
      }
    }

    return pascalData;
  }


  /**
   * Метод итеративно получает значение числа, находящегося на пересечении
   * определенного столбца и строки треугольника Паскаля
   *
   * @param row        номер строки треугольника Паскаля, начиная с нуля
   * @param col        номер столбца треугольника Паскаля, начиная с нуля
   * @param pascalData массив, в котором сохраняется полученное значение
   */
  private static void getNumIteratively(int row, int col, long[] pascalData)
  {
    int currentIndex = getIndex(row, col);

    if (col == 0 || row == col)
    {
      pascalData[currentIndex] = 1;
    }
    else
    {
      int prevLeftIndex = getIndex(row - 1, col - 1);
      int prevRightIndex = getIndex(row - 1, col);
      pascalData[currentIndex] = pascalData[prevLeftIndex] + pascalData[prevRightIndex];
    }
  }

  /*------------Вспомогательные методы-----------------*/

  /**
   * Метод визуализирует треугольник Паскаля
   *
   * @param pascalData массив значений  треугольника Паскаля
   */
  public static void display(long[] pascalData)
  {
    int row = 0;
    int rowEndIndex = 0;

    for (int i = 0; i < pascalData.length; i++)
    {
      if (i != rowEndIndex)
      {
        System.out.print(pascalData[i] + "\t");
      }
      else
      {
        System.out.print(pascalData[i] + "\n");
        row++;
        rowEndIndex = getSum(row) + row;
      }
    }
    System.out.println();
  }

  /**
   * Метод рассчета индекса элемента находящегося на пересечении
   * определенного столбца и строки треугольника Паскаля в промежуточном массиве
   *
   * @param row номер строки треугольника Паскаля, начиная с нуля
   * @param col номер столбца треугольника Паскаля, начиная с нуля
   * @return индекс элемента в массиве, содержащем числа треугольника Паскаля
   */
  private static int getIndex(int row, int col)
  {
    return getSum(row) + col;
  }

  /**
   * Метод используется для рассчета позиции начала строки треугольника Паскаля в промежуточном массиве
   *
   * @param number номер строки треугольника Паскаля (начиная с нуля)
   * @return индекс начала строки треугольника Паскаля в промежуточном массиве
   */
  private static int getSum(int number)
  {
    int sum = 0;

    for (int i = 1; i <= number; i++)
    {
      sum += i;
    }

    return sum;
  }
}
