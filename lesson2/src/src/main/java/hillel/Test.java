package hillel;

public class Test
{
  public static void main(String[] args)
  {
    printMultiplicationTable();
  }

  private static void printMultiplicationTable()
  {
    for (int i = 1; i < 10; i++)
    {
      printTableForNumber(i);
      System.out.println();
    }
  }

  private static void printTableForNumber(int i)
  {
    for (int j = 1; j < 10; j++)
    {
      System.out.printf("%d * %d = %d\n", i, j, i * j);
    }
  }
}