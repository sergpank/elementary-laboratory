package homework25.models;

import java.util.*;

public class User extends ValueObject
{
  private String login;
  private String password;
  private Group group;

  public User(String login, String password, Group group)
  {
    this(0, login, password, group);
  }

  public User(long id, String login, String password, Group group)
  {
    super(id);

    this.login = login;
    this.password = password;
    this.group = group;
  }

  public String getLogin()
  {
    return login;
  }

  public String getPassword()
  {
    return password;
  }

  public Group getGroup()
  {

    return (group != null) ? new Group(group.getId(), group.getName()) : null;
  }

  @Override
  public Map<String, Object> asPropertyMap()
  {
    Map<String, Object> map = new HashMap<>();
    map.put("Login", getLogin());
    map.put("Password", getPassword());
    map.put("Group name", getGroup().getName());

    return map;
  }


  @Override
  public String toString()
  {
    return String.format("Id: %d, login: %s, password: %s,group: %s",
        getId(), getLogin(), getPassword(), getGroup());
  }

  @Override
  public boolean equals(Object obj)
  {
    boolean result = false;

    if (this == obj)
    {
      result = true;
    }
    else if (obj != null && getClass() == obj.getClass())
    {
      User user = (User) obj;

      result = user.getId() == this.getId() &&
          Objects.equals(user.login, login)
          && Objects.equals(user.password, password);
    }


    return result;

  }
}
