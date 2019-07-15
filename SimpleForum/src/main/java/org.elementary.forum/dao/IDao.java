package org.elementary.forum.dao;

import java.util.List;

public interface IDao<T>
{
  T read(long id);

  List<T> readAll();

  T loadDependentProperty(T item, String propName);

  T create(T item);

  void update(T item);

  void delete(T item);
}
