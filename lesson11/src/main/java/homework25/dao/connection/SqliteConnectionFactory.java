package homework25.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteConnectionFactory implements IAbstractConnectionFactory
{
  private String dbName;
  private static final String driverName = "org.sqlite.JDBC";
  private static final String connectionStringPrefix = "jdbc:sqlite:";

  public SqliteConnectionFactory(String dbName)
  {
    this.dbName = dbName;
  }

  public Connection getConnection() throws Exception
  {
    Class.forName(driverName);
    Connection conection = DriverManager.getConnection(connectionStringPrefix + dbName);

    return conection;
  }

}
