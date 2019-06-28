package panko.springjdbc;

public class User
{
  long id;
  String name;
  String login;
  String password;

  public User(long id, String name, String login, String password)
  {
    this.id = id;
    this.name = name;
    this.login = login;
    this.password = password;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", login='").append(login).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
