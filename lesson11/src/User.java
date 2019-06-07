public class User extends ValueObject
{
  protected String login;
  protected String password;
  Group group;

  public User(long id, String name, String login, String password, Group group)
  {
      this.id = id;
      this.name = name;
      this.login = login;
      this.password = password;
      this.group = group;
  }
  public User(long id, String name, String login, String password)
  {
    this.id = id;
    this.name = name;
    this.login = login;
    this.password = password;
    this.group = null;
  }

  @Override
  public String toString()
  {
    return "User{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", group=" + group +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}