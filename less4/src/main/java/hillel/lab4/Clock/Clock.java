package hillel.lab4.Clock;

public class Clock
{
  private int hour, minute, second;

  public Clock(int hour, int minute, int second)
  {
    setHour(hour);
    setMinute(minute);
    setSecond(second);

  }

  public void printStandartTime()
  {
    System.out.printf(" %02d : %02d : %02d - Стандартное время \n", getHour(), getMinute(), getSecond());
  }

  public void printAmericanTime()
  {
    if (hour < 12)
    {
      System.out.printf(" %02d : %02d : %02d AM - Американское время \n", getHour(), getMinute(), getSecond());

    }
    else if (hour > 12 && hour <= 24)
    {
      this.hour = hour - 12;
      System.out.printf(" %02d : %02d : %02d PM - Американское время \n", getHour(), getMinute(), getSecond());

    }
  }

  public void Tick()
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
    System.out.printf(" %02d : %02d : %02d - +1 секунда \n", hour, minute, second);
  }

  public int getHour()
  {
    return hour;
  }

  public void setHour(int hour)
  {
    if (hour >= 0 && hour < 24)
    {
      this.hour = hour;
    }

    if (hour == 24)
    {
      this.hour = 0;

    }
    if (hour > 24)
    {
      this.hour = hour - 24;
    }
  }

  public int getMinute()
  {
    return minute;
  }

  public void setMinute(int minute)
  {
    if (minute >= 0 && minute < 60)
    {
      this.minute = minute;
    }

    if (minute == 60)
    {
      this.minute = 0;
      hour++;
    }
    if (minute > 60)
    {
      this.minute = minute - 60;
    }
  }

  public int getSecond()
  {
    return second;
  }

  public void setSecond(int second)
  {
    if (second >= 0 && second < 60)
    {
      this.second = second;
    }
    if (second == 60)
    {
      this.second = 0;
      minute++;
    }
    if (second > 60)
    {
      this.second = second - 60;
    }
  }
}
