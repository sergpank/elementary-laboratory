package lesson3.src.main.java;

public class TwoSum
{
  public int[] calcIndexes(int[] nums, int target)
  {
    for (int i=0;i<nums.length-1;i++ )
    {
      for(int j=i+1; j<nums.length; j++){
        int sum= nums[i]+nums[j];
        if(sum==target){
          return new int[]{i,j};
        }
      }
    }
    return null;
  }
}
