package GeometryPrinter;

public class GeometryPrinter
{
  public static void main(String[] args)
  {
    GeometryPrinter printer = new GeometryPrinter();
    printer.printSquare();
    printer.printTriangle();
    printer.printRightTriagle();
    printer.printLeftTriangle();
    printer.printRhombus();
    printer.printChessBoard();
  }

  private void printSquare()
  {
    int width = 8;
    for (int a = 2; a < width; a++)
    {
      for (int c = 0; c < width; c++)
      {
        if ((a != 2) && (a != 7))
        {
          if ((c != 0) && (c != 7))
          {
            System.out.print(" ");
          }
          else
          {
            System.out.print("*");
          }

        }
        else
        {
          System.out.print("*");
        }
      }

      System.out.println();
    }
    System.out.println();
  }

  private void printTriangle()
  {
    int width = 0;
    int middle = 5;
    while (width < middle)
    {
      for (int a = 0; a < (middle - width - 1); a++)
      {
        System.out.print(" ");
      }
      for (int a = 0; a < (width * 2 + 1); a++)
      {
        System.out.print("*");
      }
      System.out.println();
      width++;
    }
  }


  private void printRightTriagle()
  {
    int a = 5;
    int e = 0;
    for (int b = 6; b >= e; b--)
    {
      for (int c = 0; c <= a; c++)
      {
        if (c >= b)
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

  private void printLeftTriangle()
  {
    for (int a = 5; a >= 0; a--)
    {
      for (int b = 6; b > a; b--)
      {
        System.out.print("*");
      }
      System.out.println();
    }
    System.out.println();
  }

  private void printRhombus()
  {
    int a = 8;
    for (int b = 1; b < a; b++)
    {
      for (int c = 0; c < a; c++)
      {
        if (c == 3 && (b == 1 || b == 7))
        {
          System.out.print("*");
        }
        else if ((c == 2 || c == 4) && (b == 2 || b == 6))
        {
          System.out.print("*");
        }
        else if ((c == 1 || c == 5) && (b == 3 || b == 5))
        {
          System.out.print("*");
        }
        else if ((c == 0 || c == 6) && b == 4)
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

  private void printChessBoard()
  {
    int a = 8;
    int c = 0;
    while (a > 0)
    {
      int b = 16;
      while (b > 0)
      {
        if (c % 2 == 0)
        {
          System.out.print("*");
        }
        else
        {
          System.out.print(" ");
        }
        b--;
        c++;
      }
      System.out.println();
      a--;
      c++;
    }
  }
}
