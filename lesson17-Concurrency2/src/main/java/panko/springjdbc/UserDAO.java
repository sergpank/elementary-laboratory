package panko.springjdbc;

import java.util.List;

public class UserDAO
{
  public List<User> readAll()
  {
    String sql = "select * from users";

    return DbHelper.getJdbcTemplate().query(sql, new UserRowMapper());
  }
}
