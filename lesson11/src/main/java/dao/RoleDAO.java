package dao;

import util.DbUtil;
import vo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements DAO<Role>
{
  public static final String INSETR_role_SQL =
      "INSERT INTO role (name,description) VALUES (?,?);";
  public static final String SELECT_group_SQL =
      "SELECT * FROM role WHERE id = ?;";
  public static final String SELECT_all_role_SQL =
      "SELECT * FROM role;";
  public static final String UPDATE_role_SQL =
      "UPDATE role SET name=?,description=? WHERE id=?;";
  public static final String DELETE_role_SQL =
      "DELETE FROM role WHERE id=?;";
  @Override
  public boolean create(Role role)
  {
    boolean rezult = false;
    if (role == null){
      return rezult;
    }
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(INSETR_role_SQL);
      stmnt.setString(1,role.getName());
      stmnt.setString(2,role.getDescription());
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
  public Role read(int id)
  {
    Role role = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(SELECT_group_SQL);
      stmnt.setLong(1,id);
      ResultSet set = stmnt.executeQuery();
      if (set.next()){
        int uid = set.getInt("id");
        String name = set.getString("name");
        String description = set.getString("description");
        role = new Role(uid,name,description);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return role;
  }

  @Override
  public List<Role> read()
  {
    List<Role> roles = new ArrayList<>();
    Role role = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement statement = con.prepareStatement(SELECT_all_role_SQL);
      ResultSet set = statement.executeQuery();
      while (set.next()){
        int uid = set.getInt("id");
        String name = set.getString("name");
        String description = set.getString("description");
        role = new Role(uid,name,description);
        roles.add(role);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return roles;
  }

  @Override
  public boolean update(Role role)
  {
    boolean rezult = false;
    if (role == null){
      return rezult;
    }
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(UPDATE_role_SQL);
      stmnt.setString(1,role.getName());
      stmnt.setString(2,role.getDescription());
      stmnt.setLong(3,role.getId());
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
      PreparedStatement stmnt = con.prepareStatement(DELETE_role_SQL);
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
