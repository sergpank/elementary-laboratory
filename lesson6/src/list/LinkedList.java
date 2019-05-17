package list;

public class LinkedList
{
  private Element head;
  private Element tail;
  private int size = 0;

  private class Element
  {
    private Element next;
    private Integer data;
  }

  public void addFront(Integer data)
  {
    Element a = new Element();
    size++;
    a.data = data;
    if(head == null)
    {
      head = a;
      tail = a;
    }
    else
    {
      a.next = head;
      head = a;
    }
  }
  public void addBack(Integer data)
  {
    Element a = new Element();
    size++;
    a.data = data;
    if(head == null)
    {
      head = a;
      tail = a;
    }
    else
    {
      tail.next = a;
      tail = a;
    }
  }
  public void printList()
  {
    Element t = head;
    while(t != null)
    {
      System.out.println(t.data + " ");
      t = t.next;
    }
  }
  public Integer get(int index)
  {
    if(index >= size)
    {
      System.out.println("Запрашиваемого элемента не существует");
      return 0;
    }
    else
    {
      Element t = head;
      for (int i = 0; i < index; i++)
      {
        t = t.next;
      }
      return t.data;
    }
  }
  public Integer remove(int index)
  {
    if(head == null)
    {
      return 0;
    }
    if(head == tail)
    {
      Integer temp = head.data;
      head = null;
      tail = null;
      size--;
      return temp;
    }
    if(index == 0)
    {
      Integer temp = head.data;
      head = head.next;
      size--;
      return temp;
    }
    else
    {
      Element t = head;
      for (int i = 0; i < (index-1); i++) // перемещаемся на элемент перед тем который нам нужен
      {
        t = t.next;
      }
      if(t.next == tail)
      {
        tail = t;
      }
      Integer temp = t.next.data; // вытаскиваем с него данные
      t.next = t.next.next; // перекидываем указатель на следующий, игнорируя удаляемый
      return temp;
    }
  }
  public int getSize()
  {
    return size;
  }
  public void checkTail()
  {
    System.out.println(tail.data);
    return;
  }
  public void checkHead()
  {
    System.out.println(head.data);
    return;
  }
}