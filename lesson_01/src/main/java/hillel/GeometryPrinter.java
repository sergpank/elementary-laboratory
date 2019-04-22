package hillel;

public class GeometryPrinter
{
  public static void main(String[] args)
  {
    GeometryPrinter printer = new GeometryPrinter();

    printer.printSquare(8);
    printer.printPyramid(6);
    printer.printLeftTriangle(5);
    printer.printRightTriangle(5);
    printer.printRhombus(11);
    printer.printChessBoard();
  }

  private void printSquare(int size)
  {
    System.out.println("Square:");

    for (int row = 1; row <= size; row++)
    {
      for (int column = 1; column <= size; column++)
      {
        if (row == 1 || column == 1 || row == size || column == size)
        {
          System.out.print('*');
        }
        else
        {
          System.out.print(' ');
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  private void printPyramid(int size)
  {
    System.out.println("Pyramid:");

    for (int row = 0; row < size; row++)
    {
      for (int column = 0; column < size * 2; column++)
      {
        if (column >= (size - row) && column <= (size + row))
        {
          System.out.print('*');
        }
        else
        {
          System.out.print(' ');
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  private void printLeftTriangle(int size)
  {
    System.out.println("Left triangle:");

    for (int row = 0; row < size; row++)
    {
      for (int column = 0; column < size; column++)
      {
        System.out.print((column <= row) ? '*' : ' ');
      }
      System.out.println();
    }
    System.out.println();
  }

  private void printRightTriangle(int size)
  {
    System.out.println("Right triangle:");

    for (int row = 0; row < size; row++)
    {
      for (int column = 0; column < size; column++)
      {
        System.out.print(((size - column - 1) > row ? ' ' : '*'));
      }
      System.out.println();
    }
    System.out.println();
  }

  private void printRhombus(int size)
  {
    System.out.println("Rhombus:");

    int left = size / 2;
    int right = size / 2;
    int shift = -1;

    if (size % 2 == 0)
    {
      size++;
    }

    for (int row = 0; row <= size - 1; row++)
    {
      for (int col = 0; col < size; col++)
      {
        if (col == left || col == right)
        {
          System.out.print('*');
          if (left == 0)
          {
            shift = 1;
          }
        }
        else
        {
          System.out.print(' ');
        }
      }
      left += shift;
      right -= shift;
      System.out.println();
    }
    System.out.println();
  }

  private void printChessBoard()
  {
    System.out.println("Chessboard:");

    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 16; j++)
      {
        if (i % 2 == 0)
        {
          System.out.print(j % 2 == 0 ? '*' : ' ');
        }
        else
        {
          System.out.print(j % 2 != 0 ? '*' : ' ');
        }
      }
      System.out.println();
    }
  }
}

