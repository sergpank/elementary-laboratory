import javax.xml.bind.annotation.XmlElementRef;
import java.security.interfaces.ECKey;

public class LinkedList
{
  private int size;
  private Element first;
  private Element prev;

  private class Element
  {
    private Integer data;
    private Element next;

    public Element(Integer data)
    {
      this.data = data;
    }
  }

  public void add(Integer data)
  {
    if (first == null)
    {
      Element element = new Element(data);
      first = element;
      prev = element;
    }
    else
    {
      prev.next = new Element(data);
      prev = prev.next;
    }
    size++;
  }

  public Integer get(int index)
  {
    Element current = find(index);

    return current.data;
  }

  private Element find(int index)
  {
    Element current = first;
    int counter = 0;

    while (counter != index)
    {
      if (current.next != null)
      {
        current = current.next;
        counter++;
      }
      else
      {
        return null;
      }
    }
    return current;
  }

  /**
   * Удалить элемент из списка
   *
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {
    Element prev = find(index-1);
    Element next = find(index+1);
    prev.next=next;
    size--;

    return get(index);
  }


  public int size()
  {
    return size;
  }
}