package homework25.models;

import java.util.*;

public class Group extends ValueObject
{
  private String name;

  private List<Role> roles;

  private ICollectionLoader<Role> rolesLoader;

  public Group(String name)
  {
    this(0, name, null);
  }

  public Group(long id, String name)
  {
    this(id, name, null);
  }

  public Group(long id, String name, ICollectionLoader<Role> rolesLoader)
  {
    super(id);
    this.name = name;
    this.rolesLoader = rolesLoader;
  }

  public String getName()
  {
    return name;
  }

  public List<Role> getRoles()
  {
    if (roles == null)
    {
      if (rolesLoader != null)
      {
        roles = rolesLoader.load(getId());
      }
      else
      {
        roles = new ArrayList<>();
      }
    }

    return roles;
  }

  public void setRoles(List<Role> roles)
  {
    if (rolesLoader == null)
    {
      this.roles = roles;
    }
  }

  @Override
  public Map<String, Object> asPropertyMap()
  {
    Map<String, Object> map = new HashMap<>();
    map.put("Group name", getName());

    map.put("According roles", getRolesAsString());

    return map;
  }

  private String getRolesAsString()
  {
    if (roles == null)
    {
      getRoles();
    }

    StringBuilder roleNames = new StringBuilder();

    if (roles.size() == 0)
    {
      roleNames.append("none");
    }
    else
    {
      for (Role role : roles)
      {
        roleNames.append(role.getDescription());
        roleNames.append("; \n");
      }
    }

    return new String(roleNames);
  }

  @Override
  public String toString()

  {
    return getName();
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
      Group group = (Group) obj;

      result = group.getId() == this.getId() && Objects.equals(group.name, name);
    }


    return result;

  }
}
