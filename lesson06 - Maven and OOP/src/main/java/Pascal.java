public class Pascal
{
  public static void main(String[] args)
  {
    Pascal pascal = new Pascal();
    for (int row = 0; row <= 10; row++)
    {
      for (int col = 0; col <= row; col++)
      {
        System.out.printf("%4d ", pascal.recursive(row, col));
      }
      System.out.println();
    }
  }

  public long recursive(int row, int column)
  {
    if ((row == 0) || (column == 0) || (row == column))
    {
      return 1;
    }

    long left = recursive(row - 1, column - 1);
    long right = recursive(row - 1, column);
    return left + right;
  }
}
