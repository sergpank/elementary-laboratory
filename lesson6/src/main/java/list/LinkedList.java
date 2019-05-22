package list;

public class LinkedList
{
  Element root;

  private int size;

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
  }

  public void add(Integer data)
  {
    if (root == null)
    {
      root = new Element(data);
    }

    Element last = findLast(root);

    Element next = new Element(data);

    last.setNext(next);

    size++;
  }

  private Element findLast(Element element)
  {
    if (element.getNext() == null)
    {
      return element;
    }
    else
    {
      return findLast(element.getNext());
    }
  }

  public Integer get(int index)
  {

    return null;
  }

  /**
   * Удалить элемент из списка
   * @param index Индекс удаляемого элемента
   * @return значение элемента
   */
  public Integer remove(int index)
  {

    return null;
  }

  public int size()
  {

    return size;
  }

  public static void main(String[] args)
  {
    LinkedList linkedList = new LinkedList();
    linkedList.add(11);
    linkedList.add(12);
    linkedList.add(13);
    linkedList.add(14);

    System.out.println(linkedList.size());
  }
}
