public class TwoSum
{
  public static void main(String[] args)
  {
    int[] array = new int[10];
    for (int i = 0; i < array.length; i++)
    {
      array[i] = (int) (Math.random() * 10);
      System.out.print(array[i]);
    }
    System.out.println();
    TwoSum calc = new TwoSum();
    calc.calcIndexes(array);
  }

  private void calcIndexes(int[] array)
  {
    int a = 10;
    for (int j = 0; j < array.length; j++)
    {
      for (int k = 0; k < array.length; k++)
      {
        if (j <= k)
        {
          if (array[j] + array[k] == a)
          {
            System.out.println(a + " = " + "intex: " + j + "("+ array[j]+")"+ " and " + "intex: " + k + "("+ array[k]+")");
          }
        }
      }
    }
  }

}