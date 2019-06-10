public class TwoSum
{
  public int[] calcIndexes(int[] nums, int target)
  {
    int complement;

    for (int x = 0; x < nums.length; x++)
    {
      complement = target - nums[x];

      for (int y = 0; y < nums.length; y++)
      {

        if (x == y)
        {
          continue;
        }
        if (nums[y] == complement)
        {
          return new int[]{x, y};
        }
      }
    }
    return new int[]{0, 0};
  }
}
