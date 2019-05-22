package homework;

import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person>
{
  @Override
  public int compare(Person o1, Person o2)
  {
    String key = "Age in Yrs.";
    double p1 = Double.parseDouble(o1.getDataByKey(key))*100 ;
    double p2 = Double.parseDouble(o2.getDataByKey(key))*100 ;
        return (int)p1-(int)p2;

  }
}
