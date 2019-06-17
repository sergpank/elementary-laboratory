package homework26.util;

import java.sql.Connection;

public interface IConnectionFactory
{
  Connection getConnection();
}
