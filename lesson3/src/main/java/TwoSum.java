public class TwoSum
{
  public int[] calcIndexes(int[] mass, int target)
  {
    for (int i = 0; i < mass.length - 1; ++i)
    {
      for (int j = i + 1; j < mass.length; ++j)
      {
        if (mass[i] == mass[j])
        {
          continue;
        }
        int sum = mass[i] + mass[j];
        if (sum == target)
        {
          return new int[]{i, j};
        }
      }
    }


    return new int[]{};
  }
}
