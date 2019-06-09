package homework25.models;

import java.util.List;

public interface ICollectionLoader<T extends ValueObject>
{
  List<T> load(long key);
}
