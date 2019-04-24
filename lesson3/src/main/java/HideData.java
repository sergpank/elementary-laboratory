public class HideData
{
  private int hour;
  private int minute;
  private int second;
  public static void main(String[] args)
  {
    HideData hideData = new HideData(34,20,03);
    hideData.printAmericanTime();
    hideData.tick(3600);
    hideData.printStandartTime();
  }
  HideData(int a, int b, int c)
  {
    hour = a;
    minute = b;
    second = c;
    while(second>=60)
    {
      second-=60;
      minute++;
    }
    while(minute>=60)
    {
      minute-=60;
      hour++;
    }
    while(hour>=24)
      hour-=24;
  }
  public void printAmericanTime()
  {
    if(hour==0)
    {
      System.out.println("Текущее время: " + "0" +  ":" + (minute) + ":" + (second) + " A.M.");
    }
    if(hour>0 && hour<12)
    {
      System.out.println("Текущее время: " + (hour) +  ":" + (minute) + ":" + (second) + " A.M.");
    }
    if(hour==12)
    {
      System.out.println("Текущее время: " + (hour) +  ":" + (minute) + ":" + (second) + " P.M.");
    }
    if(hour>12)
    {
      System.out.println("Текущее время: " + (hour-12) +  ":" + (minute) + ":" + (second) + " P.M.");
    }
  }
  public void printStandartTime()
  {
    System.out.println("Текущее время: " + (hour) +  ":" + (minute) + ":" + (second));
  }
  public void tick(int i)
  {
    second+=i;
    while(second>=60)
    {
      second-=60;
      minute++;
    }
    while(minute>=60)
    {
      minute-=60;
      hour++;
    }
    while(hour>=24)
      hour-=24;
  }
  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getSecond()
  {
    return second;
  }
}