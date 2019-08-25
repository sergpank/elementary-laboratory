import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target){
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++)
    {
      map.put(nums[i],i);
    }
    int[]rez = new int[2];
    for (int i = 0; i < nums.length-1; i++)
    {
      Integer k = map.get(target - nums[i]);
      if (k != null && k!= i){
        rez[0] = i;
        rez[1] = k;
        break;
      }
    }
    return rez;
  }
}
