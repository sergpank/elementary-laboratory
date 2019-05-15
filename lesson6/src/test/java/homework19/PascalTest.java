package homework19;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalTest
{
  int depth = 5;
  long[] expected = {1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1};

  @Test
  public void test1()
  {
    long[] actual = Pascal.buildRecursively(depth);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test2()
  {
    long[] actual = Pascal.buildUsingCache(depth);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test3()
  {
    long[] actual = Pascal.buildIteratively(depth);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test4()
  {
    int triangleDepth = 20;
    long[] actual_1 = null;
    long[] actual_2 = null;
    long[] actual_3 = null;

    for (int i = 1; i <= triangleDepth; i++)
    {
      actual_1 = Pascal.buildRecursively(i);
      actual_2 = Pascal.buildUsingCache(i);
      actual_3 = Pascal.buildIteratively(i);

      assertArrayEquals(actual_1, actual_2);
      assertArrayEquals(actual_2, actual_3);
    }
  }
}
