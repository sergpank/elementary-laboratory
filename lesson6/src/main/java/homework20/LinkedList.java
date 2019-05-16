package homework20;

/*
    Извиняюсь за немножко самодеятельности. Виноват.
*/

public class LinkedList<T>
{
  private int size;
  private Element<T> first;
  private Element<T> last;

  private static class Element<T>
  {
    private Element<T> next;
    private T data;

    Element(T data)
    {
      this.data = data;
    }
  }

  public void add(T data)
  {
    @SuppressWarnings("unchecked")
    Element<T> node = (Element<T>) new Element(data);

    if (last == null)
    {
      first = node;
      last = node;
    }
    else
    {
      last.next = node;
      last = node;
    }
    size++;
  }

  public T get(int index)
  {
    Element<T> node = first;

    for (int i = 1; i <= index && node != null; i++)
    {
      node = node.next;
    }

    return (node != null) ? node.data : null;
  }

  public T getFirst()
  {
    Element<T> node = first;

    return (node != null) ? node.data : null;
  }

  public T getLast()
  {
    Element<T> node = last;

    return (node != null) ? node.data : null;
  }

  public T remove(int index)
  {
    Element<T> node = first;
    Element<T> prevNode = null;
    T removed = null;

    for (int i = 1; i <= index && node != null; i++)
    {
      prevNode = node;
      node = node.next;
    }

    if (node != null)
    {
      removed = node.data;

      if (first == node)
      {
        first = node.next;
      }
      else
      {
        prevNode.next = node.next;
      }
      if (node == last)
      {
        last = prevNode;
      }

      size--;
    }

    return removed;
  }

  public int size()
  {
    return size;
  }
}