package dao;

import util.DbUtil;
import vo.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO implements DAO<Group>
{
  public static final String INSETR_group_SQL =
      "INSERT INTO group (name,description) VALUES (?,?);";
  public static final String SELECT_group_SQL =
      "SELECT * FROM group WHERE id = ?;";
  public static final String SELECT_all_group_SQL =
      "SELECT * FROM group;";
  public static final String UPDATE_group_SQL =
      "UPDATE user SET name=?,description=? WHERE id=?;";
  public static final String DELETE_group_SQL =
      "DELETE FROM group WHERE id=?;";
  @Override
  public boolean create(Group group)
  {
    boolean rezult = false;
    if (group == null){
      return rezult;
    }
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(INSETR_group_SQL);
      stmnt.setString(1,group.getName());
      stmnt.setString(2,group.getDescription());
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
  public Group read(int id)
  {
    Group group = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(SELECT_group_SQL);
      stmnt.setLong(1,id);
      ResultSet set = stmnt.executeQuery();
      if (set.next()){
        int uid = set.getInt("id");
        String name = set.getString("name");
        String description = set.getString("description");
        group = new Group(uid,name,description);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return group;
  }

  @Override
  public List<Group> read()
  {
    List<Group> groups = new ArrayList<>();
    Group group = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(SELECT_all_group_SQL);
      ResultSet set = stmnt.executeQuery();
      while (set.next()){
        int uid = set.getInt("id");
        String name = set.getString("name");
        String description = set.getString("description");
        group = new Group(uid,name,description);
        groups.add(group);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return groups;
  }

  @Override
  public boolean update(Group group)
  {
    boolean rezult = false;
    if (group == null){
      return rezult;
    }
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement stmnt = con.prepareStatement(UPDATE_group_SQL);
      stmnt.setString(1,group.getName());
      stmnt.setString(2,group.getDescription());
      stmnt.setLong(3,group.getId());
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
      PreparedStatement stmnt = con.prepareStatement(DELETE_group_SQL);
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
