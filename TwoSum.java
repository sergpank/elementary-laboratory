package hillel.lesson3;

import java.util.Arrays;

public class TwoSum
{
  public static void main(String[] args)
  {
    int arr[] = {4, 68, 73, 14, 86, 90, 55, 43, 99, 66};
    int target = 167;
    TwoSum twoSum = new TwoSum();
    System.out.println(Arrays.toString(twoSum.calcIndexes(arr, target)));
  }

  public int[] calcIndexes(int[] nums, int target)
  {
    int tempI = 0;
    int tempJ = 0;
    for (int i = 0; i < nums.length; i++)
    {
      for (int j = 0; j < nums.length; j++)
      {
        if (nums[i] + nums[j] == target)
        {
          tempI = i;
          tempJ = j;
        }
      }
    }
    return new int[]{tempI, tempJ};
  }
}
