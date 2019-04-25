package hillel.lesson04a;

/*    printAmericanTime() - выводит в консоль время 12-часовом формате с приставкой АМ/РМ
    printStandardTime() - выводит время в 24-часовом формате
    tick() - увеличивает время на 1 секунду (если нужно увеличивает минуту и час) 10:59:59 -> tick() -> 11:00:00*/
public class Times
{
  private int hour;
  private int min;
  private int sec;

  public Times(int hour, int min, int sec)
  {
    if (hour >= 0 && hour <= 24)
    {
      this.hour = hour;
    }
    else
    {
      System.out.println("wrong input hours value!");
    }
    if (min >= 0 && min <= 60)
    {
      this.min = min;
    }
    else
    {
      this.hour+=min/60;
      this.min=min%60;
    }

    if (sec >= 0 && sec <= 60)
    {
      this.sec = sec;
    }
    else
    {
      this.min+=sec/60;
      this.sec=sec%60;
    }

  }

  public void setHour(int hour)
  {
    if (hour >= 0 && hour < 24)
    {
      this.hour = hour;
    }else if (hour==24)
    {
      this.hour=0;
    }
    else
    {
      this.hour=hour%24;
    }
  }

  public void setMin(int min)
  {
    if (min >= 0 && min <60)
    {
      this.min = min;
    }
   else if (min==60)
    {
      setHour(getHour()+1);
      this.min=0;

    }else{
      this.hour+=min/60;
      this.min=min%60;
    }
  }

  public void setSec(int sec)
  {
    if (sec >= 0 && sec < 60)
    {
      this.sec = sec;
    }else if (sec==60)
    {
      setMin(getMin()+1);
      this.sec=0;
    }
    else
    {
     this.min+=sec/60;
     this.sec=sec%60;

    }
  }

  public int getHour()
  {
    return hour;
  }

  public int getMin()
  {
    return min;
  }

  public int getSec()
  {
    return sec;
  }

  public void printAmericanTime()
  {
    if (hour >=0&& hour<=12){
    System.out.printf("%02d:%02d:%02d%4s%n",hour,min,sec,"AM");}
    else{
      int h = (hour==24)?0:hour-12;
      System.out.printf("%02d:%02d:%02d%4s%n",h,min,sec,"PM");
    }

  }

  public void printStandardTime()
  {
    System.out.printf("%02d:%02d:%02d%n",hour,min,sec);
  }

  public void tick()
  {
    setSec(getSec()+1);

  }


  public static void main(String[] args)
  {
    Times a = new Times(22, 59, 59);
    a.tick();
    a.printStandardTime();
    a.printAmericanTime();
  }
}
