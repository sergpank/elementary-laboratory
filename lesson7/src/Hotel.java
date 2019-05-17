import com.sun.jdi.IntegerValue;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Hotel
{
  public static Map<Integer, List<String>> hashMap = new HashMap<>();
  public static ArrayList<String> reviews1 = new ArrayList<>();
  public static ArrayList<String> reviews2 = new ArrayList<>();
  public static ArrayList<String> keyWords = new ArrayList<>();

  public static void main(String[] args)
  {
    Hotel hotel = new Hotel();

    reviews1.add("This hotel has a nice view of the citycenter. The location is perfect.");
    reviews1.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    reviews1.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");
    reviews2.add("The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    reviews2.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
    hashMap.put(1, reviews1);
    hashMap.put(2, reviews2);

    keyWords.add("breakfast");
    keyWords.add("beach");
    keyWords.add("citycenter");
    keyWords.add("location");
    keyWords.add("metro");
    keyWords.add("view");
    keyWords.add("staff");
    keyWords.add("price");

    hotel.sortHotel();
  }

  public void sortHotel()
  {
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 1; i <= hashMap.size(); i++)   // цикл пробегает по каждому отелю
    {
      count.put(i, 0);                                          // создаем счетчик совпадений для каждого отеля
      String temp = new String(hashMap.get(i).toString());  // содержимое списка отзывов для каждого отеля кладем в строку
      temp = temp.toLowerCase();                            // для последующей обработки
      for (int j = 0; j < keyWords.size(); j++)      // сравниваем строку с каждым ключевым словом
      {
        int t = 0;
        while (temp.indexOf(keyWords.get(j), t) >= 0) // находим индекс слова и начинаем поиск с места на котором остановились
        {
          t = temp.indexOf(keyWords.get(j), t) + 1;
          count.put(i, (count.get(i) + 1));
        }
      }
    }
    System.out.println("Рейтинг отелей по релевантности:");
    count.put(3, 14);                                  // эти два элемента добавил что-бы убедиться что сортировка работает
    count.put(4, 10);                                 // бо сортировать 2 элемента тяжело
    Map<Integer, Integer> countTemp = new HashMap<>();
    for (int i = 1; i <= count.size(); i++)       // очень костыльная сортировка хешмапа через создание еще одной карты и
    {
      countTemp.put(i, count.get(i));
    }                                         // удаления из неё "использованных" элементов
    int temp = countTemp.size();
    for(int i = 1; i <= temp; i++)
    {
      int currentMax = 1;
      for(int j = 1; j <= temp; j++)
      {
        if(countTemp.get(j)!=null)
        {
          if (countTemp.get(j) > countTemp.get(currentMax))
          {
            currentMax = j;
          }
        }
      }
      System.out.println("Отель под номером " + currentMax + ", набравший " + countTemp.get(currentMax) + " совпадений по ключевым словам");
      countTemp.remove(currentMax);
    }
  }
}
