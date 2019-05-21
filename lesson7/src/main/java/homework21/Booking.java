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

    for(Map.Entry<Hotel, Integer> entry : hotels.entrySet())
    {
      Integer value=entry.getValue();
      value+=calculateRelevance(entry.getKey(), keyword);
      entry.setValue(value);
    }

  }

  public void addReview(int hotelId, String review)
  {
    Hotel hotel = findHotelById(hotelId);

    if (hotel != null)
    {
      int relevance = hotels.get(hotel);
      hotel.addReview(review);
      relevance = relevance + calculateMatches(review);
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

  private List<Map.Entry<Hotel, Integer>> sortHotelsByRelevance()
  {
    Set<Map.Entry<Hotel, Integer>> entries = hotels.entrySet();
    ArrayList<Map.Entry<Hotel, Integer>> list = new ArrayList<>(entries);

    Collections.sort(list, Comparator.comparing((a) -> a.getValue(), (a, b) -> b.compareTo(a)));

    return list;
  }

  public Hotel[] getHotelsByRelevance()
  {
    List<Map.Entry<Hotel, Integer>> list = sortHotelsByRelevance();
    Hotel[] result = new Hotel[list.size()];
    int counter = 0;

    for (Map.Entry<Hotel, Integer> item : list)
    {
      result[counter++] = item.getKey();
    }

    return result;
  }

  public Integer getRelevance(Hotel hotel)
  {
    return hotels.get(hotel);
  }


  /**
   * Метод рассчета релевантности отзыва ключевому слову
   *
   * @param review  отзыв
   * @param keyword ключевое слово
   * @return релевантность отзыва ключевому слову
   */
  private int calculateMatches(String review, String keyword)
  {
    int result = 0;

    String str = ".*\\b" + keyword + "\\b.*";

    Pattern ptn = Pattern.compile(str, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    Matcher matcher = ptn.matcher(review);

    while (matcher.find())
    {
      result++;
    }

    return result;
  }

  /**
   * Метод рассчета релевантности отзыва по всем ключевым словам
   *
   * @param review отзыв
   * @return релевантность отзыва всем ключевым словам
   */
  private int calculateMatches(String review)
  {
    int result = 0;

    for (String keyword : keywords)
    {
      result += calculateMatches(review, keyword);
    }

    return result;
  }

  /**
   * Метод рассчета релевантности отеля по всем отзывам на него и ключевым словам
   * Используется при добавлении нового отеля в коллекцию
   *
   * @param hotel отель
   * @return релевантность отеля
   */
  private int calculateRelevance(Hotel hotel)
  {
    int result = 0;
    Collection<String> reviews = hotel.getReviews();

    if (!reviews.isEmpty())
    {
      for (String review : reviews)
      {
        result += calculateMatches(review);
      }

    }

    return result;
  }

  /**
   * Метод рассчета релевантности отеля по всем отзывам на него и одному ключевому слову
   * Используется при добавлении нового ключевого слова в коллекцию
   *
   * @param hotel   отель
   * @param keyword ключевое слово
   * @return релевантность отеля
   */
  private int calculateRelevance(Hotel hotel, String keyword)
  {
    int result = 0;
    Collection<String> reviews = hotel.getReviews();

    if (!reviews.isEmpty())
    {
      for (String review : reviews)
      {
        result = result + calculateMatches(review, keyword);
      }

    }
    return result;
  }
}