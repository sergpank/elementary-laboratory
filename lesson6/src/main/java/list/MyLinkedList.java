package list;

public class MyLinkedList
{
  private Element firstElement;
  private int size;

  private class Element
  {
    private Element next;
    private Integer data;
    private int index;

    {
      this.index++;
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

    public void setData(Integer data)
    {
      this.data = data;
    }

    public int getIndex()
    {
      return index;
    }

    public void setIndex(int index)
    {
      this.index = index;
    }
  }


  public void addFirst(Integer data)
  {
    Element e = new Element ( );
    e.next = firstElement;
    e.setData ( data );
    firstElement = e;
    this.size++;
  }

  public Integer getIndexData(int index)
  {
    Element current = firstElement;
    Integer indexData = null;
    for ( int i = 0 ; i <= index ; i++ )
    {
      indexData = current.getData ( );
      current = current.next;

    }

    return indexData;
  }


  /**
   * Удалить элемент из списка
   *
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {
    Element current = firstElement;
    Element tempElement = null;

    for ( int i = 0 ; i <= index ; i++ )
    {
      tempElement = current;
      current = current.next;
    }

    Integer temp = tempElement.getData ( );
    tempElement = tempElement.next;
    return temp;

  }

  public int size()
  {
    return size;
  }
}