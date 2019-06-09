package homework25.models;

import java.util.Map;

public abstract class ValueObject
{
  private long id;

  public ValueObject(long id)
  {
    this.id = id;
  }

  public long getId()
  {
    return id;
  }

  public abstract Map<String, Object> asPropertyMap();

}
