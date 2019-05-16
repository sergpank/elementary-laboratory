package tasks;

public class NewFactorial
{
  public static long recursive(long value){
    return value<=1?1:value*recursive(--value);
  }
  public static long iterative(long value)
  {
    int result=1;
    for(int i = 1; i<value; i++)
    {
      result = result*(i+1);
    }
    return result;
  }

  public static void main(String[] args)
  {
    System.out.println("recursive " + recursive(5));
    System.out.println("iterative " + iterative(5));
  }
}
