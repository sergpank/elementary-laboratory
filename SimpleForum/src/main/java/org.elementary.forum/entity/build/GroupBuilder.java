package org.elementary.forum.entity.build;

import org.elementary.forum.entity.Group;

public class GroupBuilder implements IEntityBuilder<Group>
{
  private Group item;

  public GroupBuilder()
  {
    item = new Group();
  }

  public GroupBuilder setName(String name)
  {
    item.setName(name);
    return this;
  }

  @Override
  public Group build() throws IllegalAccessException
  {
    if (item.getName() == null)
    {
      throw new IllegalAccessException();
    }
    return item;
  }
}