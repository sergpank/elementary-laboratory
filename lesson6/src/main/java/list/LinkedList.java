package list;


public class LinkedList
{
  private int size;
  private Element head;


  private class Element
  {
    private Element next;
    private Integer data;

    public Element(Integer data)
    {
      this.data = data;
    }
  }



  public void add(Integer data)
  {
    Element newAdded = new Element(data);

    if (size == 0)
    {
      head = newAdded;
      size++;
      return;
    }


    Element current = head;

    while (current.next != null)

    {
      current = current.next;
    }

    current.next = newAdded;
    size++;
  }

  public Integer get(int index)
  {

    if (size == 0)
    {
      throw new NullPointerException();
    }
    if (index < 0 || index >= size)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    Element current = head;



    for (int i = 0; i != index; i++)
    {
      current = current.next;
    }
    return current.data;
  }

  /**
   * Удалить элемент из списка
   *
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   *
   */
  public Integer remove(int index)
  {
    if (size == 0)
    {
      throw new NullPointerException();
    }
    if (index < 0 || index >= size)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    Element current = head;
    Element prev = current;

    for (int i = 0; i != index; i++)
    {
      prev = current;
      current = current.next;
    }
    if (current.next != null)
    {
      prev.next = current.next;
      size--;
    }else {prev.next=null;}

    return current.data;
  }

  public int size()
  {
    return size;
  }



}
