package panko.springjdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>
{
  @Override
  public User mapRow(ResultSet resultSet, int i) throws SQLException
  {
    long id = resultSet.getLong("id");
    String name = resultSet.getString("name");
    String login = resultSet.getString("login");
    String password = resultSet.getString("password");

    return new User(id, name, login, password);
  }
}

