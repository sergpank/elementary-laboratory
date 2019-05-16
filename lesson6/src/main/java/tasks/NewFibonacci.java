package tasks;

public class NewFibonacci
{
  public static long recursive(long value){
    if(value==0)
    {
      return 0;
    }else if(value==1)
    {
      return 1;
    }
    return recursive(value-1)+recursive(value-2);
  }
  public static long iterative(long value){
    long preprevious=0;
    long previous=1;
    long result = -1;
    if(value==0)
    {
      return preprevious;
    }
    if(value==1)
    {
      return previous;
    }
    for(int i = 2; i<=value; i++)
    {
      result=preprevious+previous;
      preprevious=previous;
      previous=result;
    }

    return result;
  }

  public static void main(String[] args)
  {
    System.out.println("recursive " + recursive(8));
    System.out.println("iterative " + iterative(8));
  }
}
