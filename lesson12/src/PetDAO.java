import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PetDAO implements DAO
{
  public boolean create(Pet pet) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO Pet (name, date_of_birth, type, client_id) VALUES ('" + pet.name + "','" + pet.date_of_birth + "','" +
        pet.type + "','" + pet.client_id + "')");
    return true;
  }

  public Pet read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Pet WHERE id = '" + id + "'");
    Pet pet = new Pet(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("date_of_birth"), resultSet.getString("type"), resultSet.getInt("client_id"));
    statement.close();
    return pet;
  }

  public ArrayList<Pet> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Pet> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Pet");

    while(resultSet.next())
    {
      Pet pet = new Pet(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("date_of_birth"),
          resultSet.getString("type"), resultSet.getInt("client_id"));
      list.add(pet);
    }
    statement.close();
    return list;

  }

  public boolean update(Pet pet, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Pet SET name = '" + pet.name + "', date_of_birth = '" + pet.date_of_birth + "', type = '" + pet.type + "', " +
        "client_id = '" + pet.client_id + "' WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Pet WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

}
