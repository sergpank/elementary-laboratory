/*
 * Дан массив и значение
 *
 *Вернуть индексы двух элементов массива сумма которых равна данному значению
 *
 *Гарантировано что в массиве есть только два элемента сумма которых равна данному значению.
 */
public class TwoSum
{

  /**
   * Метод ищет индексы элементов массива, сумма которых равна ключу;
   * массив может быть неупорядоченным
   *
   * @param nums   массив, в котором осуществляется поиск
   * @param target ключ, которому должна быть равна сумма 2-х элементов массива
   * @return массив из индексов искомых элементов; если элементы, удовлетворяющие условию,
   * не обнаружены массив содержит числа, равные длине исходного массива
   */
  public static int[] calcIndexes(int[] nums, int target)
  {
    int[] result = new int[]{nums.length, nums.length};

    quit:
    for (int i = 0; i < nums.length - 1; i++)
    {
      for (int j = i + 1; j < nums.length; j++)
      {
        if ((nums[i] + nums[j]) == target)
        {
          result[0] = i;
          result[1] = j;
          break quit;
        }
      }
    }

    return result;
  }

  /**
   * Метод ищет индексы элементов массива, сумма которых равна ключу;
   * массив должен быть упорядоченным
   *
   * @param nums   массив, в котором осуществляется поиск
   * @param target ключ, которому должна быть равна сумма 2-х элементов массива
   * @return массив из индексов искомых элементов; если элементы, удовлетворяющие условию,
   * не обнаружены массив содержит числа, равные длине исходного массива
   */
  public static int[] calcIndexInSortedArr(int[] nums, int target)
  {
    int[] result = new int[]{nums.length, nums.length};
    int left;
    int right;
    int mid;

    quit:
    for (int i = 0; i < nums.length - 1; i++)
    {
      left = i + 1;
      right = nums.length - 1;

      while (left <= right)
      {
        mid = (left + right) / 2;

        if ((nums[i] + nums[mid]) == target)
        {
          result[0] = i;
          result[1] = mid;
          break quit;
        }
        else if ((nums[i] + nums[mid]) > target)
        {
          right = mid - 1;
        }
        else
        {
          left = mid + 1;
        }
      }
    }

    return result;
  }
}
