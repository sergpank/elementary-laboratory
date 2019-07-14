package list;

public class LinkedList
{
  private int size;
  private Element first;
  public LinkedList()
  {
    first = null;
  }
  public class Element
  {
    private Element next;
    private Integer data;

    public Integer getData()
    {
      return data;
    }

    public Element(Integer data)
    {
      this.data = data;
    }
    public void displayElement()
    {

      System.out.println("{" + getData()+"}");
    }
  }

  public void addFirst(Integer data)
  {
    Element list = new Element(data);
    list.data = data;
    list.next = first;
    first = list;
    size++;
  }

  public Integer get(int index)
  {
    Element current = first;
    while (current.getData() != index)
    {
      if (current.next == null)
      {
        return null;
      }
      else
      {
        current = current.next;
      }
    }
    return current.getData();
  }

  /**
   * Удалить элемент из списка
   *
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {
    Element current = first;
    Element previous = first;
    while (current.getData() != index)
    {
      if (current.next == null)
      {
        return null;
      }
      else
      {
        previous = current;
        current = current.next;
      }
    }
    if (current == first)
    {
      first = first.next;
      size--;
    }
    else
    {
      previous.next = current.next;
      size--;
    }
    return current.getData();
  }

  public void displayList()
  {
    System.out.println("the list from first---> to last");
    Element current = first;
    while (current != null)
    {
      for (int i = 0; i<size();i++)
      {
        System.out.print("Element "+"["+i+"] = ");
        current.displayElement();
        current = current.next;
      }
    }
  }

  public int size()
  {
    return size;
  }


  public static void main(String[] args)
  {
   LinkedList linkedList = new LinkedList();
   linkedList.addFirst(22);
   linkedList.addFirst(35);
   linkedList.addFirst(16);


   linkedList.displayList();
   Integer a = linkedList.get(16);
    if (a != null)
      System.out.println(a);
    else
    {
      System.out.println("Nothing");
    }
    Integer d = linkedList.remove(35);
    if (d != null)
      System.out.println(d);
    else

      System.out.println("Nothing");

    linkedList.displayList();
    }

}
