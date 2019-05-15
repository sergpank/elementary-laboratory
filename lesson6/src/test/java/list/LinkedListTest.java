package list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest
{
  @Test
  public void test()
  {
    LinkedList list = new LinkedList();

    list.add(1);
    list.add(2);
    list.add(3);

    assertEquals(3, list.size());
    assertEquals(Integer.valueOf(1), list.get(0));
    assertEquals(Integer.valueOf(2), list.get(1));
    assertEquals(Integer.valueOf(3), list.get(2));

    list.remove(1);

    assertEquals(2, list.size());
    assertEquals(Integer.valueOf(1), list.get(0));
    assertEquals(Integer.valueOf(3), list.get(1));
  }
}