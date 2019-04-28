package Time;

public class Clock
{
  private int hour, minute, second;

  public Clock(int hour, int minute, int second)
  {
    if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && second >= 0 && second < 60)
    {
      setHour(hour);
      setMinute(minute);
      setSecond(second);
    }
    else
    {
      return;
    }

  }

  public void printAmericanTime()
  {

    if (hour < 12)
    {
      System.out.println(toString() + " AM");
    }
    else
    {
      hour -= 12;
      System.out.println(toString() + " PM");
      hour += 12;
    }
  }

  public void printStandartTime()
  {
    System.out.println(toString());
  }

  public void tick()
  {
    if (second == 59)
    {
      if (minute == 59)
      {
        if (hour == 23)
        {
          hour = 0;
          minute = 0;
          second = 0;
        }
        else
        {
          second = 0;
          minute = 0;
          hour += 1;
        }
      }
      else
      {
        second = 0;
        minute += 1;
      }
    }
    else
    {
      second += 1;
    }
  }

  @Override
  public String toString()
  {
    return hour + ":" + minute + ":" + second;
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

  public void setHour(int hour)
  {
    if (hour >= 0 && hour < 24)
    {
      this.hour = hour;
    }
  }

  public void setMinute(int minute)
  {
    if (minute >= 0 && minute < 60)

    {
      this.minute = minute;
    }
  }

  public void setSecond(int second)
  {
    if (second >= 0 && second < 60)
    {
      this.second = (second);
    }
  }
}
