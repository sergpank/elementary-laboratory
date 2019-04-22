public class TwoSum
{
  public int[] calcIndexes(int[] nums, int target)
  {
    int i, j, sum;
    for (i = 0; i < nums.length; i++)
    {
      sum = nums[i] + nums[i + 1];
      if (sum == target)
      {
        i = nums[i];
        j = nums[i + 1];
      }
    }
    return new int[]{i};
  }
}
