package dao;

import java.util.List;

public interface DAO <T>
{
    public boolean create(T entity);

    public T read(long id);

    public List<T> readAll();

    public boolean update(T entity);

    public boolean delete(T entity);
}
