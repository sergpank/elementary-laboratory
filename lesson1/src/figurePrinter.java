public class figurePrinter

{

  public static void main(String[] args)
  {
    printerSquare(6, 8);
    printerTriangle(5);
    printerTriangleLeft(6);
    printerTriangleRight(6);
    printerRhombus(8);
    printerChessBoard(8, 8);
  }

  public static void printerTriangleLeft(int p)
  {
    int i, j, k = 1;
    for (i = 0; i < p; i++)
    {
      for (j = 0; j < k; j++)
      {
        System.out.print("*");
      }
      k = k + 1;
      System.out.println();
    }
  }

  public static void printerTriangle(int size)
  {
    int i, j, k;
    for (i = 0; i < size + 1; i++)
    {
      for (j = size; j > i; j--)
      {
        System.out.print(" ");
      }
      for (k = 0; k < (2 * i - 1); k++)
      {
        System.out.print("*");
      }
      System.out.println();
    }

  }

  public static void printerTriangleRight(Integer base_size)
  {
    for (int x = 1; x < base_size + 1; x++)
    {
      System.out.print(makeRow(x, base_size));
      System.out.println();
    }
  }

  public static String makeRow(Integer row_num, Integer base)
  {
    String row = "";
    for (int x = base; x >= 0; x--)
    {
      if (x < row_num)
      {
        row += "*";
      }
      else
      {
        row += " ";
      }
    }
    return row;
  }

  public static void printerChessBoard(int row, int col)
  {
    for (int i = 1; i <= row; i++)
    {
      if (i % 2 == 0)
      {
        System.out.print("  ");
      }
      for (int j = 1; j <= col; j++)
      {
        System.out.print(" * ");
      }
      System.out.println();
    }
  }

  public static void printerSquare(int width, int length)
  {
    for (int i = 0; i < width; i++)
    {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("*");
      for (int j = 2; j < length; j++)
      {
        if (i == 0)
        {
          stringBuilder.append("*");
        }
        else if (i == width - 1)
        {
          stringBuilder.append("*");
        }
        else
        {
          stringBuilder.append(" ");
        }
      }
      stringBuilder.append("*");
      System.out.println(stringBuilder);
    }
  }

  public static void printerRhombus(int size)
  {
    for (int x = 1; x < size; x++)
    {
      for (int y = 0; y < size; y++)
      {
        if (y == 3 && (x == 1 || x == 7))
        {
          System.out.print("*");
        }
        else if ((y == 2 || y == 4) && (x == 2 || x == 6))
        {
          System.out.print("*");
        }
        else if ((y == 1 || y == 5) && (x == 3 || x == 5))
        {
          System.out.print("*");
        }
        else if ((y == 0 || y == 6) && x == 4)
        {
          System.out.print("*");
        }
        else
        {
          System.out.print(" ");
        }

      }
      System.out.println();
    }
    System.out.println();


  }
}








