import java.sql.Connection;

public interface DAO <T>
{
  public static Connection connection = ConnectDB.getConnection();
}