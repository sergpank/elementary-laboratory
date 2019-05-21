package compare;

import java.util.*;

public class TestCompare
{
  public static void main(String[] args)
  {
    List<Person> persons = new ArrayList<>();

    for (int i = 0; i < 10; i++)
    {
      persons.add(new Person((int) (Math.random() * 1000)));
    }

    persons.sort(new Comparator<Person>()
    {
      @Override
      public int compare(Person o1, Person o2)
      {
        return o2.compareTo(o1);
      }
    });

    persons.forEach(System.out::println);
  }
}
