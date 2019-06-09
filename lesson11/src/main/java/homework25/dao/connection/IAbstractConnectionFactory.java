package homework25.dao.connection;

import java.sql.Connection;

public interface IAbstractConnectionFactory
{
  Connection getConnection() throws Exception;
}
