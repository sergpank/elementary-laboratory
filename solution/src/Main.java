import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
  public static void main(String[] args)
  {
    Set<Integer> set = new TreeSet<>();
    set.add(5);
    set.add(6);
    set.add(1);
    set.add(9);
    Iterator iterator = set.iterator();
    while (iterator.hasNext()){
      System.out.println( iterator.next());
    }

  }
}
