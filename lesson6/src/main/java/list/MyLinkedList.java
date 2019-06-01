package list;

public class MyLinkedList
{
  private Element firstElement;
  private Element lastElement;
  private int size;

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
    Element e = new Element(data);

    if (firstElement == null)
    {
      firstElement = e;
    }
    else if (lastElement == null)
    {
      lastElement = e;
      firstElement.next = lastElement;
    }
    else
    {
      lastElement.next = e;
      lastElement = e;
    }
    this.size++;
  }

  public Integer get(int index)
  {
    Element current = firstElement;
    for (int i = 0; i < index; i++)
    {
      if (current.next == null)
      {
        throw new IndexOutOfBoundsException();
      }
      current = current.next;
    }
    return current.data;
  }

  /**
   * Удалить элемент из списка
   *
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {
    Integer tmp;
    if (index == 0)
    {
      tmp = firstElement.data;
      firstElement = firstElement.next;
      size--;
      return tmp;
    }

    Element previous = firstElement;
    Element removeMe = firstElement.next;

    while (--index > 0)
    {
      previous = removeMe;
      removeMe = removeMe.next;
    }

    Integer temp = removeMe.data;
    previous.next = removeMe.next; // remove from list
    size--;

    removeMe = null; // remove from memory

    return temp;
  }

  public int size()
  {
    return this.size;
  }

  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.add(11);
    list.add(21);
    list.add(31);
    list.add(41);

    for (int i = 0; i < list.size(); i++)
    {
      System.out.println(list.get(i));
    }

    System.out.println();

    list.remove(1);

    for (int i = 0; i < list.size(); i++)
    {
      System.out.println(list.get(i));
    }
  }
}