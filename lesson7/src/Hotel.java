import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    ArrayList<Integer> count = new ArrayList<>();
    for(int i = 1; i <= hashMap.size(); i++)   // цикл пробегает по каждому отелю
    {
      count.add(0);                                          // создаем счетчик совпадений для каждого отеля
      String temp = new String(hashMap.get(i).toString());  // содержимое списка отзывов для каждого отеля кладем в строку
      temp = temp.toLowerCase();                            // для последующей обработки
      for(int j = 0; j < keyWords.size(); j++)      // сравниваем строку с каждым ключевым словом
      {
        int t = 0;
        while(temp.indexOf(keyWords.get(j),t)>=0) // находим индекс слова и начинаем поиск с места на котором остановились
        {
          t = temp.indexOf(keyWords.get(j),t)+1;
          count.set((i-1),(count.get(i-1)+1));
        }
      }
      System.out.println("Количество совпадений ключевых слов для " + i + "го отеля равно " + count.get(i-1));
    }



  }

}
