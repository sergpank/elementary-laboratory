package logging;

import java.sql.Connection;
import java.sql.SQLException;

public class PerformanceTest
{
  public static void main(String[] args)
  {
    long withPoolStart = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++)
    {
      try (Connection c = DbUtil.getConnectionFromPool())
      {

      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    long withPoolEnd = System.currentTimeMillis();

//    System.out.println("Without pool : " + (noPoolEnd - noPoolStart));
    System.out.println("With    pool : " + (withPoolEnd - withPoolStart));
  }
}
