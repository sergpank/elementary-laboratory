import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GroupDAO
{
  public boolean create(Statement statement, Group group) throws SQLException
  {
    statement.executeQuery("SELECT * FROM Group");
    //statement.executeUpdate("INSERT INTO Group (id, name, description) VALUES ('1', 'a', 'b')");
    return true;
  }

  public void read(Statement statement, long id)
  //public User read(long id)
  {

  }

  public void read(Statement statement)
  //public List<User> read()
  {

  }

  public boolean update(Statement statement, Group group)
  {
    return true;
  }

  public boolean delete(Statement statement, long id)
  {
    return true;
  }
}
