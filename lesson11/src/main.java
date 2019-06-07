import java.io.*;
import java.net.ConnectException;
import java.sql.*;

public class main
{
  public static void main(String[] args)
  {
    loadDriver();
    UserDAO userDAO = new UserDAO();
    GroupDAO groupDAO = new GroupDAO();
    RoleDAO roleDAO = new RoleDAO();

    try (Connection connection = getConnection())
    {
      Statement statement = connection.createStatement();

      //userDAO.create(statement, new User(getID(),"Kirill","jew","money"));
      //System.out.println(userDAO.read(statement, 7).toString());
      groupDAO.create(statement, new Group("programmers", "work hard die young"));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  private static void  loadDriver()
  {
    try
    {
      Class.forName("org.sqlite.JDBC");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private static Connection getConnection()
  {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:data/lesson11.sqlite3");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return connection;
  }
  private static long getID()
  {
    File file = new File("data/countID.txt");
    try
    {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      int temp = Integer.parseInt(bufferedReader.readLine());
      bufferedReader.close();
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(String.valueOf(temp+1));
      fileWriter.close();
      return temp;
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return -1;
  }
}
