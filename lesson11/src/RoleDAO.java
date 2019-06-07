import java.sql.Statement;
import java.util.List;

public class RoleDAO
{
  public boolean create(Statement statement, Role role)
  {
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

  public boolean update(Statement statement, Role role)
  {
    return true;
  }

  public boolean delete(Statement statement, long id)
  {
    return true;
  }
}
