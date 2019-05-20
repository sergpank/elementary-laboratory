package homework21;

import java.util.*;
import java.util.regex.*;

public class Booking
{
  private Map<Hotel, Integer> hotels;
  private ArrayList<String> keywords;

  public Booking()
  {
    hotels = new HashMap<>();
    keywords = new ArrayList<>();
  }

  public void addHotel(Hotel hotel)
  {
    int relevance = 0;
    if (!hotel.getReviews().isEmpty())
    {
      relevance = calculateRelevance(hotel);
    }
    hotels.put(hotel, relevance);
  }

  public void deleteHotel(int hotelId)
  {
    Hotel removing = findHotelById(hotelId);
    if (removing != null)
    {
      hotels.remove(removing);
    }

  }

  public void addKeyword(String keyword)
  {
    keywords.add(keyword);

    hotels.forEach((hotel, relevance) -> {
      relevance = calculateRelevance(hotel);
    });
  }

  public void addReview(int hotelId, String review)
  {
    Hotel hotel = findHotelById(hotelId);

    if (hotel != null)
    {
      hotel.addReview(review);
      int relevance = calculateRelevance(hotel);
      hotels.put(hotel, relevance);
    }
  }

  public Hotel findHotelById(int hotelId)
  {
    Hotel result = null;

    for (Hotel hotel : hotels.keySet())
    {
      if (hotel.getId() == hotelId)
      {
        result = hotel;
        break;
      }
    }

    return result;
  }

  public Set<Hotel> getHotels()
  {
    return hotels.keySet();
  }

  private LinkedList<Map.Entry<Hotel, Integer>> sortHotelsByRelevance()
  {
    Set<Map.Entry<Hotel, Integer>> entries = hotels.entrySet();
    LinkedList<Map.Entry<Hotel, Integer>> list = new LinkedList<>(entries);
    Collections.sort(list,Comparator.comparing((a)->a.getValue(),(a,b)->a.compareTo(b)));

    return list;
  }

  public Hotel[] getHotelsByRelevance()
  {
    List<Map.Entry<Hotel, Integer>> list = sortHotelsByRelevance();
    Hotel[] res = new Hotel[list.size()];
    int counter = 0;

    for (Map.Entry<Hotel, Integer> item : list)
    {
      res[counter++] = item.getKey();
    }

    return res;
  }

  public Integer getRelevance(Hotel hotel)
  {
    return hotels.get(hotel);
  }

  private int calculateRelevance(Hotel hotel)
  {
    int result = 0;
    Collection<String> reviews = hotel.getReviews();
    if (!reviews.isEmpty())
    {
      for (String review : reviews)
      {
        for (String keyword : keywords)
        {
          String str = ".*\\b" + keyword + "\\b.*";
          Pattern ptn = Pattern.compile(str, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
          Matcher matcher = ptn.matcher(review);
          while (matcher.find())
          {
            result++;
          }
        }
      }

    }
    return result;
  }
}