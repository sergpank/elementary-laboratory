package bookingHashmapVersion;

import java.util.*;

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
    for(Map.Entry<Integer,Integer> e : sort(reviews).entrySet())
    {
      System.out.printf("Hotel %d has rank %d", e.getValue(),e.getKey());
      System.out.println();
    }

  }

  public static int findKeywords(HashMap <Integer, ArrayList <String>> reviews, int Id)
  {
    int count = 0;
    for(String s: reviews.get(Id))
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
  public static Map<Integer, Integer> sort(HashMap <Integer, ArrayList <String>> reviews)
  {
    Map<Integer, Integer> sorted = new TreeMap<>();
    for(Map.Entry<Integer,ArrayList<String>> e : reviews.entrySet())
    {
      sorted.put(findKeywords(reviews, e.getKey()), e.getKey());
    }
    return sorted;
  }
}
