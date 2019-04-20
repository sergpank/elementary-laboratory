import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest
{
  @Test
  public void test()
  {
    int[] expected = new int[]{0, 1};

    int[] actual = TwoSum.calcIndexes(new int[]{2, 7, 11, 15}, 9);

    Assert.assertEquals(expected.length, actual.length);
    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void test2()
  {
    int[] expected = new int[]{4, 4};

    int[] actual = TwoSum.calcIndexes(new int[]{2, 6, 11, 15}, 9);

    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void test3()
  {
    int[] expected = new int[]{2, 3};

    int[] actual = TwoSum.calcIndexes(new int[]{11, 15, 7, 2}, 9);

    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void test4()
  {
    int[] expected = new int[]{0, 1};

    int[] actual = TwoSum.calcIndexInSortedArr(new int[]{2, 7, 11, 15}, 9);

    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void test5()
  {
    int[] expected = new int[]{1, 4};

    int[] actual = TwoSum.calcIndexInSortedArr(new int[]{2, 7, 11, 15, 16}, 23);

    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void test6()
  {
    int[] expected = new int[]{5, 5};

    int[] actual = TwoSum.calcIndexInSortedArr(new int[]{2, 5, 11, 15, 16}, 23);

    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }
}