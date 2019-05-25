package roman_numbers;

import java.util.*;

public class NumberConverter
{
  private static NavigableMap<Integer, String> romanDigits;
  private static Map<Integer, Integer> boundPrevs;

  private StringBuilder builder = new StringBuilder();

  static
  {
    romanDigits = new TreeMap<>();
    romanDigits.put(1, "I");
    romanDigits.put(5, "V");
    romanDigits.put(10, "X");
    romanDigits.put(50, "L");
    romanDigits.put(100, "C");
    romanDigits.put(500, "D");
    romanDigits.put(1000, "M");

    boundPrevs = new HashMap<>();
    boundPrevs.put(1, 1);
    boundPrevs.put(5, 1);
    boundPrevs.put(10, 1);
    boundPrevs.put(50, 10);
    boundPrevs.put(100, 10);
    boundPrevs.put(500, 100);
    boundPrevs.put(1000, 100);
  }


  /**
   * Простой и наглядный метод преобразования арабского числа в римское
   * разработан методом пошагового модульного тестирования
   * требуемое римское число формируется в поле builder класса NumberConverter
   *
   * @param num число для преобразования в римское, значения меньше 1 или больше 3999 не обрабатываются
   */
  private void convertToRomanNumber(int num)
  {
    if (num < 1 || num > 3999)
    {
      return;
    }

    if (num / 1000 > 0 && num / 1000 < 4) //from 1000 to 3999
    {
      for (int i = 0; i < num / 1000; i++)
      {
        builder.append(romanDigits.get(1000));
      }
      convertToRomanNumber(num % 1000);
    }
    else if (num / 500 > 0) //from 500 to 999
    {
      if (num % 1000 >= 900)
      {
        builder.append(romanDigits.get(100));
        builder.append(romanDigits.get(1000));
        convertToRomanNumber(num % 100);
      }
      else
      {
        builder.append(romanDigits.get(500));
        convertToRomanNumber(num % 500);
      }
    }
    else if (num / 100 > 0) //from 100 to 499
    {
      if (num % 500 >= 400)
      {
        builder.append(romanDigits.get(100));
        builder.append(romanDigits.get(500));
        convertToRomanNumber(num % 100);
      }
      else
      {
        for (int i = 0; i < num / 100; i++)
        {
          builder.append(romanDigits.get(100));
        }
        convertToRomanNumber(num % 100);
      }
    }
    else if (num / 50 > 0) //from 50 to 99
    {
      if (num % 100 >= 90)
      {
        builder.append(romanDigits.get(10));
        builder.append(romanDigits.get(100));
        convertToRomanNumber(num % 10);
      }
      else
      {
        builder.append(romanDigits.get(50));
        convertToRomanNumber(num % 50);
      }
    }
    else if (num / 10 > 0) //from 10 to 49
    {
      if (num % 50 >= 40)
      {
        builder.append(romanDigits.get(10));
        builder.append(romanDigits.get(50));
        convertToRomanNumber(num % 10);
      }
      else
      {
        for (int i = 0; i < num / 10; i++)
        {
          builder.append(romanDigits.get(10));
        }
        convertToRomanNumber(num % 10);
      }

    }
    else if (num / 5 > 0) //from 5 to 9
    {
      if (num % 10 == 9)
      {
        builder.append(romanDigits.get(1));
        builder.append(romanDigits.get(10));
      }
      else
      {
        builder.append(romanDigits.get(5));
        convertToRomanNumber(num % 5);
      }


    }
    else // from 1 to 4
    {
      if (num % 5 == 4)
      {
        builder.append(romanDigits.get(1));
        builder.append(romanDigits.get(5));
      }
      else
      {
        for (int i = 0; i < num % 5; i++)
        {
          builder.append(romanDigits.get(1));
        }
      }

    }
  }

  /**
   * Затейливый метод преобразования арабского числа в римское
   * кода меньше но его читабельность гораздо хуже
   * но и магических чисел нет
   * требуемое римское число формируется в поле builder класса NumberConverter
   *
   * @param num число для преобразования в римское, значения меньше 1 или больше 3999 не обрабатываются
   */
  private void convertToRomanNumber2(int num)
  {
    if (num < 1 || num > 3999)
    {
      return;
    }

    int bound = romanDigits.lastEntry().getKey();

    while (bound > romanDigits.firstEntry().getKey() && bound > num)
    {
      bound = romanDigits.lowerKey(bound);
    }

    Integer boundTop = bound != romanDigits.lastEntry().getKey() ? romanDigits.higherKey(bound) : null;

    if (boundTop != null && num % boundTop >= boundTop - boundPrevs.get(boundTop))
    {
      builder.append(romanDigits.get(boundPrevs.get(boundTop)));
      builder.append(romanDigits.get(boundTop));

      if (bound != romanDigits.firstEntry().getKey())
      {
        convertToRomanNumber2(num % (boundTop - boundPrevs.get(boundTop)));
      }
    }
    else
    {
      if (isFirstDigitOne(bound))
      {
        for (int i = 0; i < num / bound; i++)
        {
          builder.append(romanDigits.get(bound));
        }
      }
      else
      {
        builder.append(romanDigits.get(bound));
      }
      if (bound != romanDigits.firstEntry().getKey())
      {
        convertToRomanNumber2(num % bound);
      }
    }
  }

  public String toRomanNumber2(int num)
  {
    builder = new StringBuilder();

    convertToRomanNumber2(num);

    return new String(builder);
  }

  public String toRomanNumber(int num)
  {
    builder = new StringBuilder();

    convertToRomanNumber(num);

    return new String(builder);
  }

  /**
   * Метод для преобразования римских чисел в арабские
   *
   * @param rNum римское число в виде строки
   * @return соответствующее арабское число
   */
  public int fromRomanNumber(String rNum)
  {
    Map<Character, Integer> rDigits = new HashMap<>();
    rDigits.put('I', 1);
    rDigits.put('V', 5);
    rDigits.put('X', 10);
    rDigits.put('L', 50);
    rDigits.put('C', 100);
    rDigits.put('D', 500);
    rDigits.put('M', 1000);

    int result = 0;

    char[] nums = new char[rNum.length()];
    for (int i = 0; i < nums.length; i++)
    {
      nums[i] = rNum.charAt(i);
    }

    for (int i = 0; i < nums.length; i++)
    {
      if (i < nums.length - 1 && rDigits.get(nums[i]) < rDigits.get(nums[i + 1]))
      {
        result += rDigits.get(nums[i + 1]) - rDigits.get(nums[i]);
        i++;
      }
      else
      {
        result += rDigits.get(nums[i]);
      }
    }

    return result;
  }

  protected static boolean isFirstDigitOne(int number)
  {
    boolean result = false;

    while (number > 0)
    {
      if (number / 10 == 0 && number % 10 == 1)
      {
        result = true;
        break;
      }
      number /= 10;
    }

    return result;
  }
}
