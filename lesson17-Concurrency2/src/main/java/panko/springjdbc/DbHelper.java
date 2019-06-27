package panko.springjdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by sergpank on 21.04.15.
 */
public class DbHelper
{
  private static final Logger LOG = LoggerFactory.getLogger(DbHelper.class);

  private static final String PROTOCOL = "jdbc:sqlite:";
  private static final String DB_LOCATION = "lesson17-Concurrency2/resources/DB.sqlite3";

  private static HikariDataSource dataSource;

  private static JdbcTemplate jdbcTemplate;

  private static void init()
  {
    HikariConfig config = new HikariConfig();
    config.setPoolName("SQLitePool");
    config.setDriverClassName("org.sqlite.JDBC");
    config.setJdbcUrl(PROTOCOL + DB_LOCATION);
    config.setConnectionTestQuery("SELECT 1");
    config.setMaxLifetime(60000); // 60 Sec
    config.setIdleTimeout(45000); // 45 Sec
    config.setMaximumPoolSize(1); // 50 Connections (including idle connections)
    dataSource = new HikariDataSource(config);

    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public static JdbcTemplate getJdbcTemplate()
  {
    if (jdbcTemplate == null)
    {
      init();
    }
    return jdbcTemplate;
  }
}
