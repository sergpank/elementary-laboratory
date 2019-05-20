package bookingHashmapVersion;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelSort
{
  public static void main(String[] args)
  {
    HashMap<Integer, ArrayList<String>> reviews = new HashMap<>();
    ArrayList <String> ID1 = new ArrayList<>();
    ArrayList <String> ID2 = new ArrayList<>();
    ID1.add("This hotel has a nice view of the citycenter. The location is perfect");
    ID1.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    ID1.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");
    ID2.add("The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    ID2.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
    reviews.put(1, ID1);
    reviews.put(2,ID2);
    for(Integer i: sort(reviews,1,2))
    {
      System.out.println(i + " ");
    }

  }

  public static int findKeywords(HashMap <Integer, ArrayList <String>> reviews, Integer ID)
  {
    int count = 0;
    for(String s: reviews.get(ID))
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
          count++;
        }
      }
    }
    return count;
  }
  public static ArrayList<Integer> sort(HashMap <Integer, ArrayList <String>> reviews, Integer firstHotel, Integer secondHotel)
  {
    ArrayList <Integer> sorted = new ArrayList<>();
    if((findKeywords(reviews, firstHotel)>findKeywords(reviews, secondHotel)))
    {
      sorted.add(firstHotel);
      sorted.add(secondHotel);
    }
    else
    {
      sorted.add(secondHotel);
      sorted.add(firstHotel);
    }
    return sorted;
  }
}
