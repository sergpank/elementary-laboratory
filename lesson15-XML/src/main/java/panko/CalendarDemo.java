package panko;

import java.util.Calendar;

public class CalendarDemo
{
  public static void main(String[] args)
  {
    Calendar c1 = Calendar.getInstance();
    c1.set(Calendar.HOUR, 0);
    c1.set(Calendar.MINUTE, 0);
    System.out.println(c1.getTime());

    Calendar c2 = Calendar.getInstance();
    c2.add(Calendar.YEAR, 1);
    System.out.println(c2.getTime());
  }
}
