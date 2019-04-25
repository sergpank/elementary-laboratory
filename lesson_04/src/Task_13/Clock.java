package Task_13;

public class Clock
{
  private int time;
  private int minute;
  private int second;

  public Clock(int time, int minute, int second)
  {
    setTime(time);
    setMinute(minute);
    setSecond(second);
  }

  public void printAmericanTime()
  {
    if (this.time <= 12)
    {
      System.out.format("AmericanTime: AM  " + "%02d:%02d:%02d%n" + "\n", time, minute, second);
    }
    if (this.time > 12)
    {
      this.time -= 12;
      System.out.format("AmericanTime: PM " + "%02d:%02d:%02d%n" + "\n", time, minute, second);
    }
  }

  public void printStandardTime()
  {
    System.out.format("Time is now: " + "%02d:%02d:%02d%n" + "\n", time, minute, second);
  }

  public void tick()
  {
    System.out.format("Time is now: " + "%02d:%02d:%02d%n", time, minute, second);
    if (this.minute == 59 & this.second == 59)
    {
      this.second = 0;
      this.minute = 0;
      this.time++;
      System.out.format("Time with tick: " + "%02d:%02d:%02d%n" + "\n", time, minute, second);
    }
  }


  public int getTime()
  {
    return time;
  }

  public void setTime(int time)
  {
    if (time >= 0 && time < 24)
    {
      this.time = time;
    }
    else
    {
      System.out.println("Enter the correct time");
    }

  }

  public int getMinute()
  {
    return minute;
  }

  public void setMinute(int minute)
  {
    if (time >= 0 && time < 59)
    {
      this.minute = minute;
    }
    else
    {
      System.out.println("Enter the correct time");
    }
  }

  public int getSecond()
  {
    return second;
  }

  public void setSecond(int second)
  {
    if (time >= 0 && time < 59)
    {
      this.second = second;
    }
    else
    {
      System.out.println("Enter the correct time");
    }
  }

  @Override
  public String toString()

  {
    return "Time is now: \n" + time + ":" + minute + ":" + second;
  }
}
