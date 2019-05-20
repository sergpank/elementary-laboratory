import java.util.*;

public class Booking
{
  List<Hotel> hotels;
  List<String> keyList;


  public Booking(List<String> keyList)
  {
    this.hotels = new ArrayList<>();
    this.keyList = keyList;
  }

  public boolean addHotel(Hotel hotel)
  {
    return hotels.add(hotel);
  }

  public void showRelHotel()
  {
    HotelComparator comparator = new HotelComparator();
    calcRelevance();
    hotels.sort(comparator);
    Iterator<Hotel> iterator = hotels.iterator();
    while (iterator.hasNext())
    {
      Hotel hotel = iterator.next();
      System.out.println(hotel.getId() + " количество совпадений - " + hotel.getRel());
    }
  }
  public boolean addKeyWord(String key){
    return keyList.add(key);
  }
  private void calcRelevance()
  {
    for (Hotel hotel : hotels)
    {
      hotel.calkRelevance(keyList);
    }
  }
}
