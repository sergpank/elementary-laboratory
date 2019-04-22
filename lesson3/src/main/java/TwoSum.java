public class TwoSum
{
  public static void main(String[] args)
  {
    TwoSum twoSum = new TwoSum();
    int[] array = new int[20];
    for(int i = 0; i < 20; i++)
    {
      array[i]= i;
    }
    for(int i = 0; i < 20; i++)
    {
      System.out.print(array[i]+" ");
    }
    twoSum.calcIndxes(array, 42);

  }
  public void calcIndxes(int[] array, int target)
  {
    for(int i = 0; i < 20; i++)
    {
      for(int j = 0; j < 20; j++)
      {
        if((array[i]+array[j]==target))
        {
          System.out.println(i + " " + j);
          return;
        }
      }
    }
    System.out.println("Не найдено соответствий");
  }
}