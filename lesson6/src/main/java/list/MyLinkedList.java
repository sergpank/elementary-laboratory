package list;

public class MyLinkedList
{
  private Element firstElement;
  private int size;

  private class Element
  {
    private Element next;
    private Integer data;

    public Integer getData()
    {
      return data;
    }

    public void setData(Integer data)
    {
      this.data = data;
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
    tempElement.next = tempElement.next.next;
    size--;
    return temp;

  }

  public int size()
  {
    return this.size;
  }

    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(11);
        list.addFirst(21);
        list.addFirst(31);
        list.addFirst(41);

        for (int i = 0; i < list.size(); i ++)
        {
            System.out.println(list.getIndexData(i));
        }

        System.out.println();

        list.remove(2);

        for (int i = 0; i < list.size(); i ++)
        {
            System.out.println(list.getIndexData(i));
        }
    }
}