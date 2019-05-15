public class FactorialMine
{
  public int recursive(int i)
  {
    int result;
    if (i <= 1)
    {
      result = 1;
    }

    else
    {
      result = i * recursive ( --i );
    }
    return result;
  }

  public int iterative(int i)
  {
    int result = 1;

    while (i > 1)
    {
      result = result * i--;
    }
    return result;

  }


  public static void main(String[] args)
  {
    FactorialMine factorial = new FactorialMine ( );
    System.out.println ( "recursive " + factorial.recursive ( 5 ) );
    System.out.println ( "iterative " + factorial.iterative ( 5 ) );

  }
}