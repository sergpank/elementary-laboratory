import java.sql.Connection;

public interface DAO
{
  Connection connection = ConnectionDB.getConnection();
}
