public class Factorial
{
  public static void main(String[] args)
  {
    Factorial factorial = new Factorial();
    System.out.println(factorial.factorialR(5));
    System.out.println(factorial.factorialI(0));

  }
  public int factorialR(int i)
  {
    if(i <= 1)
    {
      return 1;
    }
    else
    {
      return (i*factorialR(i-1));
    }
  }
  public int factorialI(int i)
  {
    int result = 1;
    for(int a = 1; a < i; a++)
    {
      result*=(a+1);
    }
    return result;
  }
}
// все понятно, сделал сам
