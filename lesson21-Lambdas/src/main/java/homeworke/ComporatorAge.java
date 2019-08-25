package homeworke;

import java.util.Comparator;

public class ComporatorAge implements Comparator<Employee>
{
  @Override
  public int compare(Employee o1, Employee o2)
  {
    return Double.valueOf(o1.getAge()).compareTo(o2.getAge());
  }
}
