
import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest
{
  @Test
  public void test()
  {
    int[] expected = new int[]{0, 1};

    TwoSum twoSum = new TwoSum();
    int[] actual = twoSum.calcIndexes(new int[]{7, 2, 11, 15}, 9);

    Assert.assertEquals(expected.length, actual.length);
    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }
}