
import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest
{
  @Test
  public void test()
  {
    int[] expected = new int[]{1, 4};

    TwoSum twoSum = new TwoSum();
    int[] actual = twoSum.calcIndexes(new int[]{7, 4,5,5,6,15}, 10);

    Assert.assertEquals(expected.length, actual.length);
    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }
}