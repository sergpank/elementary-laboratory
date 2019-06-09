public class User extends ValueObject
{
  protected String login;
  protected String password;
  Group group;

  public User(String name, String login, String password, Group group)
  {
      this.name = name;
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
        ", group=" + group +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}