public class StackOverflow
{
  public static void main(String[] args)
  {
    try
    {
      new StackOverflow().call(1);
    }
    catch (Throwable t)
    {
      System.out.println("\n\n\n" + t.getClass().getName() + " : " + t.getMessage());
    }
  }

  public void call(int i)
  {
    System.out.println(i);
    i++;
    call(i);
  }
}
