package hillel;

import java.util.Arrays;
import java.util.Random;

public class FindMax
{
  public static void main(String[] args)
  {
    int arraySize = 100;
    int maxNumbers = 3;
    FindMax app = new FindMax();

    int[] numbers = app.generateRandomArray(arraySize);

    System.out.println("Generated : " + Arrays.toString(numbers));
    app.sort(numbers, maxNumbers);
    System.out.println("Sorted    : " + Arrays.toString(numbers));

    app.printResult(maxNumbers, numbers);
  }

  private void printResult(int maxNumbers, int[] numbers)
  {
    System.out.printf("First %d max numbers: ", maxNumbers);
    for (int i = 0; i < maxNumbers; i++)
    {
      System.out.print(numbers[i] + ", ");
    }
  }

  private void sort(int[] arr, int maxNumbers)
  {
    for (int i = 0; i < maxNumbers; i++)
    {
      for (int j = i; j < arr.length; j++)
      {
        if (arr[i] < arr[j])
        {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
    }
  }

  private int[] generateRandomArray(int size)
  {
    int[] result = new int[size];
    Random random = new Random();

    for (int i = 0; i < size; i++)
    {
      result[i] = random.nextInt(size);
    }

    return result;
  }
}
