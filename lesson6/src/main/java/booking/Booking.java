package booking;

import java.util.ArrayList;
import java.util.Comparator;

public class Booking
{
  public ArrayList<Hotel> hotels;

  public Booking(ArrayList<Hotel> hotels)
  {
    this.hotels = hotels;
  }

  public void sortByRevalance(ArrayList<Hotel> hotels)
  {
    hotels.sort(new HotelComporator());
    for(int i = hotels.size()-1; i>=0;i--)
    {
      System.out.println(hotels.get(i).id);
    }
  }

  public static void main(String[] args)
  {
    ArrayList<Hotel> hotels = new ArrayList<>();
    ArrayList <String> id1 = new ArrayList<>();
    ArrayList <String> id2 = new ArrayList<>();
    id1.add("This hotel has a nice view of the citycenter. The location is perfect");
    id1.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    id1.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");
    id2.add("The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    id2.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
    Hotel h1 = new Hotel(id1,1);
    Hotel h2 = new Hotel(id2, 2);
    hotels.add(h2);
    hotels.add(h1);
    Booking b = new Booking(hotels);
    b.sortByRevalance(hotels);

  }
}
class Hotel
{

  public Hotel(ArrayList<String> reviews, int id)
  {
    this.reviews = reviews;
    this.id = id;
    this.keysCount = findKeywords(reviews);
  }


  public ArrayList <String> reviews;
  public int keysCount;
  public int id;
  private static int findKeywords(ArrayList<String>reviews)
  {
    int i = 0;
    for(String s: reviews)
    {
      for(String d: s.split("\\s|\\.|\\,"))
      {
        if(d.equalsIgnoreCase("breakfast")||
            d.equalsIgnoreCase("location")||
            d.equalsIgnoreCase("beach")||
            d.equalsIgnoreCase("citycenter")||
            d.equalsIgnoreCase("metro")||
            d.equalsIgnoreCase("staff")||
            d.equalsIgnoreCase("view")||
            d.equalsIgnoreCase("price"))
        {
          i++;
        }
      }
    }
    return i;
  }


}
class HotelComporator implements Comparator<Hotel>
{
  @Override
  public int compare(Hotel o1, Hotel o2)
  {
    return ((String.valueOf(o1.keysCount))).compareTo(String.valueOf(o2.keysCount));
  }
}


