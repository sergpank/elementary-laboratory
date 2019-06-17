package homework26.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter
{
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  public static String dateToString(LocalDate date)
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    return date.format(formatter);
  }

  public static LocalDate stringToDate(String date)
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    return LocalDate.parse(date, formatter);
  }
}
