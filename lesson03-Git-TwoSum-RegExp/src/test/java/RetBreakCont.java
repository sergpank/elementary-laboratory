import org.junit.Test;

public class RetBreakCont
{

  @Test
  public void testBreak3()
  {
    for (int i = 0; i < 10; i++)
    {
      System.out.println("i = " + i);
      for (int j = 0; j < 10; j++)
      {
        System.out.print("j = " + j + " ; ");

        if (j % 2 == 0)
        {
          continue;
        }

        if (j > 5)
        {
          System.out.println("break j");
          break;
        }
      }

      if (i == 7)
      {
        System.out.println("break i");
        break;
      }
    }
  }

  @Test
  public void testBreak1()
  {
    for (int i = 0; i < 10; i++)
    {
      if (i > 5)
      {
        break;
      }
      System.out.println(i);
    }
  }

  @Test
  public void testBreak2()
  {
    ReturnNum testReturnNum = new ReturnNum();
    testReturnNum.test(-2);
  }
}
