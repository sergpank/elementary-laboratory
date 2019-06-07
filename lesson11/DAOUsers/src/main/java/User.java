public class User extends ValueObject
{
  private String login;
  private String password;
  private Group group;

  public User(long id, String name, String login, String password, Group groupID)
  {
    super(id, name);
    this.login = login;
    this.password = password;
    this.group = groupID;
  }

  public User(String name, String login, String password, Group groupID)
  {
    super(name);
    this.login = login;
    this.password = password;
    this.group = groupID;
  }
  public User() { }



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

  @Override
  public String toString()
  {
    return super.getId() + " | " +
        super.getName() + "  \t| " +
        getLogin() + "  \t| " +
        getPassword() + " | " +
        group;

  }
}
