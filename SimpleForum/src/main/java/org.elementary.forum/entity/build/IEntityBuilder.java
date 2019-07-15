package org.elementary.forum.entity.build;

public interface IEntityBuilder<T>
{
  T build() throws IllegalAccessException;
}
