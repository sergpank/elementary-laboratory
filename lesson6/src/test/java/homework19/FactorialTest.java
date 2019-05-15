package homework19;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest
{
  long[] expected = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800};

  @Test
  public void test1()
  {
    long[] actual = new long[expected.length];

    for (int i = 0; i < actual.length; i++)
    {
      actual[i] = Factorial.getFactorialRc(i);
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void test2()
  {
    long[] actual = new long[expected.length];

    for (int i = 0; i < actual.length; i++)
    {
      actual[i] = Factorial.getFactorialIter(i);
    }

    assertArrayEquals(expected, actual);
  }
}