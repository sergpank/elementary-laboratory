import java.util.Arrays;

public class TwoSum
{
  public int[] calcIndexes(int[] nums, int target)
  {
    int[] index = new int[2];

  outer:  for (int i = 0; i < nums.length-1; i++)
    {
      for (int j = 0; j < nums.length; j++)
      {
        if (i == j)
        {
          continue;
        }
        if (nums[i] + nums[j] == target)
        {

          index[0]=i;
          index[1]=j;
          break outer;

        }
      }
    }
    return index;
  }



}
