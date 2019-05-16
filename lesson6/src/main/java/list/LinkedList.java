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


    public Element getNext()
    {
      return next;
    }

    public void setNext(Element next)
    {
      this.next = next;
    }

    public Integer getData()
    {
      return data;
    }


  }

  public void add(Integer data)
  {
    Element newAdded = new Element(data);

    if (isEmpty())
    {
      head = newAdded;
      size++;
      return;
    }
    Element current = head;

    while (current.getNext() != null)
    {

      current = current.getNext();


    }

    current.setNext(newAdded);
    size++;

  }

  public Integer get(int index)
  {
    if (isEmpty())
    {
      throw new NullPointerException();
    }

    if (index < 0 || index >= size)
    {
      throw new ArrayIndexOutOfBoundsException("Wrong Index");
    }

    Element target = head;

    for (int i = 0; i < index; i++)
    {
      target = target.getNext();

    }

    return target.getData();
  }


  /**
   * Удалить элемент из списка
   *
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {

    if (isEmpty())
    {
      throw new NullPointerException();
    }

    if (index < 0 || index >= size)
    {
      throw new ArrayIndexOutOfBoundsException("Wrong Index");
    }


    Element target = head;
    Element prev = target;

    for (int i = 0; i < index; i++)
    {
      prev = target;
      target = target.getNext();
    }
    if (target.getNext() != null)
    {
      prev.setNext(target.getNext());
      size--;
    }else {prev.setNext(null);
    size--;}


    return target.getData();
  }

  public int size()
  {
    return size;
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public static void main(String[] args)
  {
    LinkedList a = new LinkedList();
    a.add(1);
    a.add(2);
    a.add(3);

    a.remove(2);
    System.out.println(a.get(0)+" ; "+ a.get(1));

  }
}
