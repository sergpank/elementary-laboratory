package entity;

import service.GroupService;

import java.sql.SQLException;

public class UserVO extends ValueObject
{
  GroupService groupService = new GroupService();
  private String login;
  private String password;
  GroupVO group;
  static int counter=1;

  {
    this.id = counter++;
  }

  public UserVO()
  {

  }

  public String getLogin()
  {
    return login;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public long getGroup()
  {
    return group.getId();
  }

  public void setGroup(long group_id) throws SQLException
  {
    this.group = groupService.read(group_id);
  }


  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    UserVO userVO = (UserVO) o;

    if (id != userVO.id)
    {
      return false;
    }
    if (login != null ? !login.equals(userVO.login) : userVO.login != null)
    {
      return false;
    }
    if (password != null ? !password.equals(userVO.password) : userVO.password != null)
    {
      return false;
    }
    return group != null ? group.equals(userVO.group) : userVO.group == null;

  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }

  @Override
  public String toString()
  {
    return "UserVO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", group=" + group +
        '}';
  }
}
