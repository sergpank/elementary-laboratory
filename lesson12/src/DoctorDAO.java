import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorDAO implements DAO
{
  public boolean create(Doctor doctor) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO Doctor (name, surname, date_of_birth, phone_number) VALUES ('" + doctor.name + "','" + doctor.surname + "','"
    + doctor.date_of_birth + "','" + doctor.phone_number + "')");
    return true;
  }

  public Doctor read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Doctor WHERE id = '" + id + "'");
    Doctor doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("date_of_birth"),
        resultSet.getString("phone_number"));
    statement.close();
    return doctor;

  }

  public ArrayList<Doctor> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Doctor> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Doctor");

    while(resultSet.next())
    {
      Doctor doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("date_of_birth"),
          resultSet.getString("phone_number"));
      list.add(doctor);
    }
    statement.close();
    return list;

  }

  public boolean update(Doctor doctor, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Doctor SET name = '" + doctor.name + "', surname = '" + doctor.surname + "', date_of_birth = '" + doctor.date_of_birth + "', " +
        "phone_number = '" + doctor.phone_number + "' WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Doctor WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

}
