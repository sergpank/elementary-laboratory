package learn_hibernate.entity.builder;

public interface IEntityBuilder<T>
{
  T build() throws IllegalAccessException;
}
