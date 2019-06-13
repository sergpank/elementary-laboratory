package main.entity;

public class User extends ValueObject
{
  private String login;
  private String password;
  private Group group;

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
    return group;
  }

  public User(long id, String name, String login, String password, Group group)
  {
    super(id, name);
    this.login = login;
    this.password = password;
    this.group = group;
  }

  @Override
  public String toString()
  {
    return "User{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", groupId=" + group.getId() +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  public User(String name, String login, String password, Group group)
  {
    super(name);
    this.login = login;
    this.password = password;
    this.group = group;
  }
}
