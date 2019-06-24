package list;

public class LinkedList
{
  Element header;
  Element prev;
  private int size = 0;

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
    if (header == null)
    {
      header = new Element(data);
      prev = header;
      size++;
    }
    else
    {
      prev.next = new Element(data);
      prev = prev.next;
      size++;
    }
  }

  private Element find (int index)
  {
    Element current = header;
    int counter = 0;
    while (counter != index)
    {
      if (current.next == null)
      {
        return null;
      }
      else
      {
        current =  current.next;
        counter++;
      }
    }
    return current;
  }

  public Integer get(int index)
  {
    return find(index).data;
  }

  /**
   * Удалить элемент из списка
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {
    Element last = find(index - 1);
    Element next = find(index + 1);
    last.next = next;
    size--;
    return find(index).data;
  }

  public int size()
  {
    return size;
  }

//  public static void main(String[] args)
//  {
//    LinkedList linkedList = new LinkedList();
//    linkedList.add(11);
//    linkedList.add(12);
//    linkedList.add(13);
//    linkedList.add(14);
//
//    System.out.println(linkedList.size());
//  }
}
