package homework25;

import homework25.dao.connection.SqliteConnectionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;


/**
 * Класс содержит вспомогательные методы для инициализации  базы данных и добавления начальных данных
 */
public class SqliteDbHelper
{
  private SqliteConnectionFactory connectionFactory;

  public SqliteDbHelper(SqliteConnectionFactory factory)
  {
    connectionFactory = factory;
  }

  public void initDb(String pathToSql)
  {
    File file = new File(pathToSql);

    if (file.exists())
    {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader reader = new BufferedReader(new FileReader(file)))
      {
        String line;
        while ((line = reader.readLine()) != null)
        {
          sb.append(line);
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

      String[] queries = sb.toString().split(";");

      try (Connection connection = connectionFactory.getConnection())
      {

        for (String str : queries)
        {
          Statement st = connection.createStatement();
          st.executeUpdate(str);
          st.close();
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

    }

  }

  public void clearTable(String tableName)
  {
    String query = "DELETE FROM " + tableName;
    try (Connection connection = connectionFactory.getConnection();
         Statement st = connection.createStatement())
    {
      st.executeUpdate(query);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void dropTable(String tableName)
  {
    String query = "DROP TABLE IF EXISTS " + tableName;
    try (Connection connection = connectionFactory.getConnection();
         Statement st = connection.createStatement())
    {
      st.executeUpdate(query);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void seed()
  {
    clearTable("groups");
    clearTable("users");
    clearTable("roles");

    String query = "INSERT INTO groups (name) VALUES (\"admins\"), (\"managers\"), (\"users\");";
    try (Connection connection = connectionFactory.getConnection())
    {
      Statement st = connection.createStatement();
      st.executeUpdate(query);
      st.close();
      query = "INSERT INTO users (login, password, groupId)" +
          "VALUES " +
          "(\"Vasya\", \"Vasya123\", (SELECT id From groups WHERE name Like \"users\")), " +
          "(\"Petya\", \"Petya123\", (SELECT id From groups WHERE name Like \"managers\")), " +
          "(\"Vanya\", \"Vanya123\", (SELECT id From groups WHERE name Like \"admins\"));";
      st = connection.createStatement();
      st.executeUpdate(query);

      st.close();

      query = "INSERT INTO roles (description) VALUES (\"admin functions\"), (\"manager functions\"), (\"user functions\");";
      st = connection.createStatement();
      st.executeUpdate(query);

      st.close();

      query = "INSERT INTO groupsAndRoles (groupId, roleId) VALUES " +
          "((SELECT id FROM groups WHERE name=\"admins\"),(SELECT id FROM roles WHERE description=\"admin functions\"))," +
          "((SELECT id FROM groups WHERE name=\"admins\"),(SELECT id FROM roles WHERE description=\"user functions\"));";

      st = connection.createStatement();
      st.executeUpdate(query);

      st.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

}
