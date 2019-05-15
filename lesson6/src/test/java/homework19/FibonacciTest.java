package homework19;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest
{
  long[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21,
      34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711};

  @Test
  public void test1()
  {
    long[] actual = new long[expected.length];

    for (int i = 0; i < actual.length; i++)
    {
      actual[i] = Fibonacci.getNumRc(i);
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void test2()
  {
    long[] actual = new long[expected.length];

    for (int i = 0; i < actual.length; i++)
    {
      actual[i] = Fibonacci.getNumRcCached(i);
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void test3()
  {
    long[] actual = new long[expected.length];

    for (int i = 0; i < actual.length; i++)
    {
      actual[i] = Fibonacci.getNumIteratively(i);
    }

    assertArrayEquals(expected, actual);
  }
}