package homework20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest
{
  @Test
  public void test1()
  {
    LinkedList<Integer> list = new LinkedList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    assertEquals(5, list.size());

    assertEquals(Integer.valueOf(1), list.getFirst());
    assertEquals(Integer.valueOf(5), list.getLast());

    assertEquals(Integer.valueOf(1), list.get(0));
    assertEquals(Integer.valueOf(2), list.get(1));
    assertEquals(Integer.valueOf(3), list.get(2));

    list.remove(0);
    assertEquals(4, list.size());
    assertEquals(Integer.valueOf(2), list.getFirst());
    assertEquals(Integer.valueOf(4), list.get(2));

    list.remove(3);
    assertEquals(3, list.size());
    assertEquals(Integer.valueOf(4), list.getLast());
    assertEquals(Integer.valueOf(4), list.get(2));

    assertNull(list.remove(3));
    assertEquals(3, list.size());

    assertNull(list.get(3));
  }

}