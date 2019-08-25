package dao;

import util.DbUtil;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User>
{
  public static final String INSETR_user_SQL =
      "INSERT INTO user (name,login,password) VALUES (?,?,?);";
  public static final String SELECT_user_SQL =
      "SELECT * FROM user WHERE id = ?;";
  public static final String SELECT_all_user_SQL =
      "SELECT * FROM user;";
  public static final String UPDATE_user_SQL =
      "UPDATE user SET name=?, login=?, password=? WHERE id=?;";
  public static final String DELETE_user_SQL =
      "DELETE FROM user WHERE id=?;";
  @Override
  public boolean create(User user)
  {
    boolean rezult = false;
    if (user == null){
      return rezult;
    }
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(INSETR_user_SQL);
      stmnt.setString(1,user.getName());
      stmnt.setString(2,user.getLogin());
      stmnt.setString(3,user.getPassword());
      if (stmnt.executeUpdate() == 1){
        rezult = true;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return rezult;
  }

  @Override
  public User read(int id)
  {
    User user = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(SELECT_user_SQL);
      stmnt.setLong(1,id);
      ResultSet set = stmnt.executeQuery();
      if (set.next()){
        int uid = set.getInt("id");
        String name = set.getString("name");
        String login = set.getString("login");
        String password = set.getString("password");
        user = new User(uid,name,login,password);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public List<User> read()
  {
    List<User> users = new ArrayList<>();
    User user = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(SELECT_all_user_SQL);
      ResultSet set = stmnt.executeQuery();
      while (set.next()){
        int uid = set.getInt("id");
        String name = set.getString("name");
        String login = set.getString("login");
        String password = set.getString("password");
        user = new User(uid,name,login,password);
        users.add(user);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public boolean update(User user)
  {
    boolean rezult = false;
    if (user == null){
      return rezult;
    }
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(UPDATE_user_SQL);
      stmnt.setString(1,user.getName());
      stmnt.setString(2,user.getLogin());
      stmnt.setString(3,user.getPassword());
      stmnt.setLong(4,user.getId());
      if (stmnt.executeUpdate() == 1){
        rezult = true;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return rezult;
  }

  @Override
  public boolean delete(int id)
  {
    boolean rezult = false;

    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(DELETE_user_SQL);
      stmnt.setLong(1,id);

      if (stmnt.executeUpdate() == 1){
        rezult = true;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return rezult;
  }
}
