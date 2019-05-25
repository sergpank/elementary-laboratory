package roman_numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberConverterTest
{
  Map<Integer, String> map;

  public NumberConverterTest()
  {
    String path = "RomanNumbers.csv";
    map = getNumbersFromFile(path);
  }

  @Test
  public void test0()
  {
    assertTrue(!map.isEmpty());
    assertEquals(map.get(1), "I");
  }


  @Test
  public void test1()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 1; i < 10; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  @Test
  public void test2()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 10; i < 50; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  @Test
  public void test3()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 50; i < 100; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  @Test
  public void test4()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 100; i < 500; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  @Test
  public void test5()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 500; i < 1000; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  @Test
  public void test6()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 1000; i < 4000; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  @Test
  public void test7()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 1; i < 4000; i++)
      {
        int actual = converter.fromRomanNumber(map.get(i));
        int expected = i;
        assertEquals(expected, actual);
      }
    }

  }


  @Test
  public void test8()
  {
    NumberConverter converter = new NumberConverter();

    for (int i = 1000; i < 4000; i++)
    {
      String romanNum = converter.toRomanNumber(i);
      int actual = converter.fromRomanNumber(romanNum);
      assertEquals(i, actual);

    }
  }

  @Test
  public void test9()
  {
    int[] nums1 = {1, 10, 100, 1000};
    int[] nums2 = {5, 50, 500, 2000};

    for (int i = 0; i < nums1.length; i++)
    {
      assertTrue(NumberConverter.isFirstDigitOne(nums1[i]));
      assertFalse(NumberConverter.isFirstDigitOne(nums2[i]));
    }
  }

  @Test
  public void test10()
  {
    if (!map.isEmpty())
    {
      NumberConverter converter = new NumberConverter();

      for (int i = 1; i < 4000; i++)
      {
        if (map.get(i) != null)
        {
          String actual = converter.toRomanNumber2(i);
          String expected = map.get(i);
          assertEquals(expected, actual);
        }

      }
    }
  }

  /**
   * Метод для чтения значений римских чисел из файла (от 1 до 3999)
   *
   * @param pathToFile путь к файлу со значениями римских чисел
   * @return отображение значений арабских чисел на римские
   */
  private Map<Integer, String> getNumbersFromFile(String pathToFile)
  {
    File file = new File(pathToFile);
    Map<Integer, String> map = new HashMap<>();
    if (file.exists())
    {
      try (BufferedReader reader = new BufferedReader(new FileReader(file)))
      {
        String line = "";
        String[] split;
        while ((line = reader.readLine()) != null)
        {
          split = line.split(",");
          map.put(Integer.parseInt(split[0]), split[1]);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

    }

    return map;
  }



}
