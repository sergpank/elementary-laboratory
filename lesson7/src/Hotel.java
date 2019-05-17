import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel
{
  public static Map<Integer, String> hashMap = new HashMap<>();
  public static ArrayList<String> keyWords = new ArrayList<>();
  public static void main(String[] args)
  {
    Hotel hotel = new Hotel();

    hotel.addHotel(0001, "This hotel has a nice view of the citycenter. The location is perfect.");
    hotel.addHotel(0002, "The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    hotel.addHotel(0001, "Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    hotel.addHotel(0001, "They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");
    hotel.addHotel(0002, "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

    hotel.addKeyWords("breakfast");
    hotel.addKeyWords("beach");
    hotel.addKeyWords("citycenter");
    hotel.addKeyWords("location");
    hotel.addKeyWords("metro");
    hotel.addKeyWords("view");
    hotel.addKeyWords("staff");
    hotel.addKeyWords("price");

    hotel.sortHotel();
  }
  public void addHotel(Integer id, String review)
  {
    hashMap.put(id, review);
  }

  public void addKeyWords(String s)
  {
    keyWords.add(s);
  }

  public void sortHotel()
  {
    System.out.println(hashMap.get(0001));
  }

}
