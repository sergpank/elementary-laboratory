package vo;

public class User extends ValueObject
{
  private String login;
  private String password;

  public User(int id, String name, String login, String password)
  {
    super(id, name);
    this.login = login;
    this.password = password;
  }

  public User(String name, String login, String password)
  {
    super(name);
    this.login = login;
    this.password = password;
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

  @Override
  public String toString()
  {
    return "vo.User{" + super.toString() +
        " login='" + login + '\'' +
        ", password='" + password + '\'' +
        '}';
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

    User user = (User) o;

    if (!login.equals(user.login))
    {
      return false;
    }
    return password.equals(user.password);
  }

  @Override
  public int hashCode()
  {
    int result = login.hashCode();
    result = 31 * result + password.hashCode();
    return result;
  }
}
