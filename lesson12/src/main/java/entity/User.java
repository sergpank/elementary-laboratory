package entity;

public class User
{
    private long id;
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password)
    {
        this(0, name, login, password);
    }

    public User(long id, String name, String login, String password)
    {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("entity.User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        User other = (User) o;

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }
        if (!this.getLogin().equals(other.getLogin()))
        {
            return false;
        }
        if (!this.getPassword().equals(other.getPassword()))
        {
            return false;
        }

        return true;
    }
}
