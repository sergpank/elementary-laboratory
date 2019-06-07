import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T extends ValueObject>
{
  Connection connection;
  final static String CLASSPATH = "jdbc:sqlite:users.db";

  public abstract boolean create(T  object);
  public abstract List<T> read();
  public abstract T read(long id);
  public abstract boolean update(T object);
  public abstract boolean delete(long id);

  public boolean open()
  {
    try
    {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection(CLASSPATH);

      System.out.println("Connected to users.db \n");
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }

  public boolean close()
  {
    try
    {
      connection.close();
      System.out.println("users.db connection was closed ");
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }

}
