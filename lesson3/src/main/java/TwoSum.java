public class TwoSum
{
  public int[] calcIndexes(int[] nums, int target)
  {
    int a = 0;
    int b = 0;
    for(int  i = 0; i<nums.length; i++)
    {
      for (int j = 0; j < nums.length; j++)
      {
        if (target == nums[i] + nums[j] && i!=j)
        {
          a = i;
          b = j;
        }
      }
      if(a!=0 && b!=0){
        break;
      }
    }
    System.out.println(a);
    System.out.println(b);

    return new int[]{b,a};
  }
}
