import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VisitDAO implements DAO
{
  public boolean create(Visit visit) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO Visit (date, doctor_id, client_id, pet_id, description, charge) VALUES ('" + visit.date + "','" + visit.doctor_id + "','"
        + visit.client_id + "','" + visit.pet_id + "','" + visit.description + "','" + visit.charge + "')");
    return true;
  }

  public Visit read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Visit WHERE id = '" + id + "'");
    Visit visit = new Visit(resultSet.getInt("id"), resultSet.getString("date"), resultSet.getInt("doctor_id"), resultSet.getInt("client_id"),
        resultSet.getInt("pet_id"), resultSet.getString("description"), resultSet.getString("charge"));
    statement.close();
    return visit;

  }

  public ArrayList<Visit> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Visit> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Visit");

    while(resultSet.next())
    {
      Visit visit = new Visit(resultSet.getInt("id"), resultSet.getString("date"), resultSet.getInt("doctor_id"), resultSet.getInt("client_id"),
          resultSet.getInt("pet_id"), resultSet.getString("description"), resultSet.getString("charge"));
      list.add(visit);
    }
    statement.close();
    return list;

  }

  public boolean update(Visit visit, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Visit SET date = '" + visit.date + "', doctor_id = '" + visit.doctor_id + "', client_id = '" + visit.client_id + "', " +
        "pet_id = '" + visit.pet_id + "', description = '" + visit.description + "', charge = '" + visit.charge + "' WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Visit WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

}
