package list;

public class main
{
  public static void main(String[] args)
  {
    LinkedList linkedList = new LinkedList();
    linkedList.addFront(5);
    linkedList.addFront(3);
    linkedList.addBack(6);
    linkedList.addBack(7);
    linkedList.printList();
    System.out.println("---------------");
    linkedList.checkTail();
    System.out.println("---------------");
    linkedList.remove(3);
    linkedList.printList();
    System.out.println("---------------");
    linkedList.checkTail();
  }
}
