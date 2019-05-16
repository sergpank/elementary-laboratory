package tasks;

public class NewPascalTriangle
{
  public static int recursive(int row, int column)
  {
    if(column == 0 || row == 0 || column==row)
    {
      return 1;
    }
    int left = recursive(row-1,column-1);
    int right = recursive(row-1,column);
    return left + right;
  }

  public static void main(String[] args)
  {
    for(int i = 0; i<=10; i ++)
    {
      for(int j = 0;j<=i;j++)
      {
        System.out.printf("%4d",recursive(i,j));
      }
      System.out.println();
    }
  }
}
