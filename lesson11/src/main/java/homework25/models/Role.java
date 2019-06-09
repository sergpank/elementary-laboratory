package homework25.models;

import java.util.*;

public class Role extends ValueObject
{
  private String description;
  private List<Group> groups;
  private ICollectionLoader<Group> groupsLoader;

  public Role(String description)
  {
    this(0, description, null);
  }

  public Role(long id, String description)
  {
    this(id, description, null);
  }

  public Role(long id, String description, ICollectionLoader<Group> groupsLoader)
  {
    super(id);
    this.description = description;
    this.groupsLoader = groupsLoader;
  }

  public String getDescription()
  {
    return description;
  }

  public List<Group> getGroups()
  {
    if (groups == null)
    {
      if (groupsLoader != null)
      {
        groups = groupsLoader.load(getId());
      }
      else
      {
        groups = new ArrayList<>();
      }
    }

    return groups;
  }

  public void setGroups(List<Group> groups)
  {
    if (groupsLoader == null)
    {
      this.groups = groups;
    }
  }


  @Override
  public Map<String, Object> asPropertyMap()
  {
    Map<String, Object> map = new HashMap<>();
    map.put("Role description", getDescription());

    map.put("According groups", getGroupsAsString());

    return map;
  }

  private String getGroupsAsString()
  {
    if (groups == null)
    {
      getGroups();
    }

    StringBuilder groupNames = new StringBuilder();

    if (groups.size() == 0)
    {
      groupNames.append("none");
    }
    else
    {
      for (Group group : groups)
      {
        groupNames.append(group.getName());
        groupNames.append("; ");
      }
    }

    return new String(groupNames);
  }

  @Override
  public String toString()
  {
    return getDescription();
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
      Role role = (Role) obj;

      result = role.getId() == this.getId() && Objects.equals(role.description, description);
    }

    return result;

  }
}
