package main.java.hillel.clock;

public class Clock
{
  private int hour;
  private int minet;
  private int second;

  public Clock(int hour, int minet, int second)
  {
    setHour(hour);
    setMinet(minet);
    setSecond(second);

  }


  public void printStandardTime()
  {
    System.out.format("Standart time %02d : %02d : %02d%n", hour,minet,second);
  }

  public void printAmericanTime()
  {
    if (hour < 12)
    {
      System.out.format("AmericanTime: " + " AM "+ "%02d : %02d : %02d%n",hour,minet,second );
    }
    else if (hour < 24)
    {
      int pmHour = hour - 12;
      System.out.format("AmericanTime: " + " PM "+ "%02d : %02d : %02d%n",pmHour,minet,second );
    }
  }

  public void tick()
  {
    if (second != 59)
    {
      second++;
    }
    else if (minet != 59)
    {
      minet++;
      second = 0;
    }
    else if (hour != 23)
    {
      hour++;
      minet = 0;
      second=0;
    }
    else
    {
      hour = 0;
      minet = 0;
      second=0;
    }
    System.out.format("Up time 1 second: %02d : %02d : %02d%n ",hour,minet,second);
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
    else
    {
      System.out.println("Input correct hours from 0 to 23 ");
    }
  }

  public int getMinet()
  {
    return minet;
  }

  public void setMinet(int minet)
  {
    if (minet >= 0 && minet < 60)
    {
      this.minet = minet;
    }
    else
    {
      System.out.println("Input correct minets from 0 to 59 ");
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
    else
    {
      System.out.println("Input correct seconds from 0 to 59 ");
    }
  }

  @Override
  public String toString()
  {
    return "Clock{" +
        "hour=" + hour +
        ", minet=" + minet +
        ", second=" + second +
        '}';
  }
}
