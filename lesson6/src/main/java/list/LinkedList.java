package list;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class LinkedList
{
  private int size;
  private Element first = null;
  private Element last=null;

  private class Element
  {
    private Element next;
    private Integer data;

    public Element(Integer data)
    {
      this.data = data;
      this.next=null;
    }
  }

  public void add(Integer data)
  {
    if(first==null)
    {
      first = new Element(data);
      last = first;
    }
    else
    {
      last.next=new Element(data);
      last=last.next;
    }
    size++;
  }

  public Element find(int index)
  {
    Element current = first;
    int count=0;
    if(index>=size||index<0){
      throw new IndexOutOfBoundsException();
    }
    else
    {
      while (count != index)
      {
        current = current.next;
        count++;
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
    Integer temp = find(index).data;
    find(index-1).next=find(index).next;
    size--;
    return temp;
  }

  public int size()
  {
    return size;
  }
}
