package hillel.lesson4.time;


public class Time
{
  private int hour;
  private int minute;
  private int second;

  public int getHour()
  {
    return hour;
  }

  public void setHour(int hour)
  {
    if (hour < 0 || hour > 23)
    {
      System.out.println("Wrong time entry format \ntry again");
    }
    else
    {
      this.hour = hour;
    }
  }

  public int getMinute()
  {
    return minute;
  }

  public Time()
  {
  }

  public void setMinute(int minute)
  {
    if (minute < 0 || minute > 59)
    {
      System.out.println("Wrong time entry format \ntry again");
    }
    else
    {
      this.minute = minute;
    }
  }

  public int getSecond()
  {
    return second;
  }

  public void setSecond(int second)
  {
    if (second < 0 || second > 59)
    {
      System.out.println("Wrong time entry format \ntry again");
    }
    else
    {
      this.second = second;
    }
  }

  public Time(int hour, int minute, int second)
  {
    if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59)
    {
      System.out.println("Wrong time entry format \ntry again");
    }
    else
    {
      this.hour = hour;
      this.minute = minute;
      this.second = second;
    }
  }


  protected void printAmericanTime()
  {
    if (hour >= 0 && hour < 12)
    {
      if (hour == 0)
      {
        System.out.println(hour + 12 + ":" + zeroMinute() + ":" + zeroSecond() + " AM");
      }
      else
      {
        System.out.println(hour + ":" + zeroMinute() + ":" + zeroSecond() + " AM");
      }
    }
    else
    {
      if (hour == 12)
      {
        System.out.println(hour + ":" + zeroMinute() + ":" + zeroSecond() + " PM");
      }
      else
      {
        System.out.println(hour - 12 + ":" + zeroMinute() + ":" + zeroSecond() + " PM");
      }
    }
  }

  protected void printStandardTime()
  {
    System.out.println(zeroHour() + ":" + zeroMinute() + ":" + zeroSecond());
  }

  protected void tick()
  {
    if (second==59)
    {
      second=0;
      if (minute==59)
      {
        minute=0;
        if (hour==23)
        {
          hour=0;
        }else
          {
            hour+=1;
          }
      }else
        {
          minute+=1;
        }

    }else
      {
        second+=1;
      }
  }

  private String zeroHour()
  {
    String str1;
    if (hour < 10)
    {
      str1 = "0" + hour;
    }
    else
    {
      str1 = "" + hour;
    }
    return str1;
  }

  private String zeroMinute()
  {
    String str1;
    if (minute < 10)
    {
      str1 = "0" + minute;
    }
    else
    {
      str1 = "" + minute;
    }
    return str1;
  }

  private String zeroSecond()
  {
    String str1;
    if (second < 10)
    {
      str1 = "0" + second;
    }
    else
    {
      str1 = "" + second;
    }
    return str1;
  }
}

