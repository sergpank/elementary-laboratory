package chugunov.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SQLiteDbUtil extends DbUtil
{
  public SQLiteDbUtil(String dbLocation)
  {
    super(dbLocation);
  }

  @Override
  protected void init()
  {
    String protocol = "jdbc:sqlite:";

    HikariConfig config = new HikariConfig();
    config.setPoolName("SQLitePool");
    config.setDriverClassName("org.sqlite.JDBC");
    config.setJdbcUrl(protocol + dbLocation);
    config.setConnectionTestQuery("SELECT 1");
    config.setMaxLifetime(60000); // 60 Sec
    config.setIdleTimeout(45000); // 45 Sec
    config.setMaximumPoolSize(10); // 50 Connections (including idle connections)
    dataSource = new HikariDataSource(config);
  }
}
