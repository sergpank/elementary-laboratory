public class ReturnNum
{
    public void test(int i)
  {
    System.out.println("Test i = " + i);
    if ( i > 100)
    {
      System.out.println(100);
      return;
    }

    System.out.println("< 100");
    if (i > 10)
    {
      System.out.println(10);
      return;
    }

    System.out.println("< 10");
    if ( i > 0)
    {
      System.out.println(0);
      return;
    }

    System.out.println("< 0 !!!");
  }
}
