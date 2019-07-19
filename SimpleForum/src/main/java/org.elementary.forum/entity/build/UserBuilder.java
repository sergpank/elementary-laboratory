package org.elementary.forum.entity.build;

import org.elementary.forum.entity.Group;
import org.elementary.forum.entity.User;

import java.util.Date;

public class UserBuilder implements IEntityBuilder<User>
{
  private User item;

  public UserBuilder()
  {
    item = new User();
  }

  public UserBuilder setLogin(String login)
  {
    item.setLogin(login);
    return this;
  }

  public UserBuilder setPassword(String password)
  {
    item.setPassword(password);
    return this;
  }

  public UserBuilder setRegistrationDate(Date date)
  {
    item.setRegistrationDate(date);
    return this;
  }

  public UserBuilder setGroup(Group group)
  {
    item.setGroup(group);
    return this;
  }

  @Override
  public User build() throws IllegalAccessException
  {
    if (item.getLogin() == null
        || item.getPassword() == null
        || item.getRegistrationDate() == null
        || item.getGroup().getId() == null)
    {
      throw new IllegalAccessException();
    }
    return item;
  }
}
