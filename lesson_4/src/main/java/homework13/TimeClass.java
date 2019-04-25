package homework13;

public class TimeClass
{
  private int hours;
  private int minutes;
  private int seconds;

  public TimeClass()
  {
    this(0, 0, 0);
  }

  public TimeClass(int seconds)
  {
    this(0, 0, seconds);
  }

  public TimeClass(int minutes, int seconds)
  {
    this(0, minutes, seconds);
  }

  public TimeClass(int hours, int minutes, int seconds)
  {
    seconds = (seconds < 0) ? -seconds : seconds;
    minutes = (minutes < 0) ? -minutes : minutes;
    hours = (hours < 0) ? -hours : hours;

    this.seconds = seconds % 60;
    this.minutes = (minutes + seconds / 60) % 60;
    this.hours = (hours + minutes / 60 + seconds / 60 / 60) % 24;
  }

  public int getSeconds()
  {
    return seconds;
  }

  public int getMinutes()
  {
    return minutes;
  }

  public int getHours()
  {
    return hours;
  }

  /**
   * Устанавливает секундную составляющую времени. Если переданное значение больше 59,
   * увеличиваются также и старшие составляющие времени
   *
   * @param seconds Количество секунд. Может быть больше 59. Должен быть больше 0
   */
  public void setSeconds(int seconds)
  {
    seconds = (seconds < 0) ? -seconds : seconds;

    this.seconds = seconds % 60;
    this.minutes += seconds / 60;
    this.hours += this.minutes / 60;
    this.minutes %= 60;
    this.hours %= 24;
  }

  /**
   * Устанавливает минутную составляющую времени. Если переданное значение больше 59,
   * увеличивается также и часовая составляющая времени
   *
   * @param minutes Количество минут. Может быть больше 59. Должен быть больше 0
   */
  public void setMinutes(int minutes)
  {
    minutes = (minutes < 0) ? -minutes : minutes;

    this.minutes = minutes % 60;
    this.hours += minutes / 60;
    this.hours %= 24;
  }

  /**
   * Устанавливает часовую составляющую. Если переданное значение больше 23,
   * в качестве значения составляющей будет установлен остаток от деления переданной величины на 24
   *
   * @param hours Количество часов. Должен быть больше 0 и меньше 24
   */
  public void setHours(int hours)
  {
    hours = (hours < 0) ? -hours : hours;

    this.hours = hours % 24;
  }

  String getStandardTime()
  {
    return String.format("%1$02d:%2$02d:%3$02d", this.hours, this.minutes, this.seconds);
  }

  public void printStandardTime()
  {
    System.out.println(getStandardTime());
  }

  String getAmericanTime()
  {
    int h = (this.hours <= 12) ? this.hours : this.hours % 12;
    String mark = (this.hours < 12) ? "AM" : "PM";

    return String.format("%1$02d:%2$02d:%3$02d %4$s", h, this.minutes, this.seconds, mark);
  }

  public void printAmericanTime()
  {

    System.out.println(getAmericanTime());
  }

  public void tick()
  {
    this.seconds++;
    if (this.seconds > 59)
    {
      this.seconds = 0;
      this.minutes++;
      if (this.minutes > 59)
      {
        this.minutes = 0;
        this.hours++;
        if (this.hours > 23)
        {
          this.hours = 0;
        }
      }
    }
  }
}
