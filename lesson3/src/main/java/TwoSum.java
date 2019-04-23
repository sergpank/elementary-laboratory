public class TwoSum
{
  public int[] calcIndexes(int[] nums, int target)
  {
    int sum;

    for (int index1 = 0; index1 < nums.length; index1++)
    {
      for (int index2 = 1; index2 < nums.length - 1; index2++)
      {
        if (index1 == index2)
        {
          continue;
        }

        sum = nums[index1] + nums[index2];
        if (sum == target)
        {
          System.out.println(index1 + " " + index2);
          return new int[]{index1, index2};
        }
      }
    }
    return new int[]{};
  }
}
