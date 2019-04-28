package MyFirstArray;

public class MyFirstArray
{
  public static void main(String[] args)
  {
    int[] array = new int[100];
    for (int i = 0; i < array.length; i++)
    {
      array[i] = (int) (Math.random() * 100);
    }
    for (int i = 0; i < array.length; i++)
    {
      int num = array[i];
      for (int j = i - 1; j >= 0; j--)
      {
        int LeftNumber = array[j];
        if (num < LeftNumber)
        {
          array[j + 1] = LeftNumber;
          array[j] = num;
        }
        else
        {
          break;
        }
      }

    }
    System.out.println(array[97]);
    System.out.println(array[98]);
    System.out.println(array[99]);
  }
}

