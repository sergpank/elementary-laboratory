import java.sql.Connection;

public interface DAO <T>
{
  Connection connection = ConnectDB.getConnection();
}