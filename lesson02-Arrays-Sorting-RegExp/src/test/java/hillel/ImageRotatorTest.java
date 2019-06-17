package hillel;

import org.junit.Assert;
import org.junit.Test;

public class ImageRotatorTest
{
  @Test
  public void test()
  {
    int[][] img = new int[][]
        {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

    int[][] expected = new int[][]
        {
            {3, 6, 9},
            {2, 5, 8},
            {1, 4, 7}
        };

    int[][] actual = new ImageRotator().rotate(img);

    Assert.assertArrayEquals(expected, actual);
  }
}
