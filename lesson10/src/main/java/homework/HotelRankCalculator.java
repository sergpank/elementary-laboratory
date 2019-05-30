package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HotelRankCalculator
{
  public Map<Integer, Set<Integer>> calculate(Set<String> keys, Map<Integer, List<String>> reviewMap)
  {
    Map<Integer, Integer> hotelIdToRankMap = calculateHotelsRank(keys, reviewMap);
    final Map<Integer, Set<Integer>> rantToHotelIdMap = sortByRank(hotelIdToRankMap);
    return rantToHotelIdMap;
  }

  private Map<Integer, Integer> calculateHotelsRank(Set<String> keys, Map<Integer, List<String>> reviewMap)
  {
    Map<Integer, Integer> hotelRankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : reviewMap.entrySet())
    {
      Integer hotelId = entry.getKey();
      List<String> hotelReviews = entry.getValue();

      int hotelRank = calculateHotelRank(keys, hotelReviews);
      hotelRankMap.put(hotelId, hotelRank);
    }

    return hotelRankMap;
  }

  private int  calculateHotelRank(Set<String> keys, List<String> hotelReviews)
  {
    int hotelRank = 0;

    for (String review : hotelReviews)
    {
      hotelRank += calculateReviewRank(keys, review);
    }

    return hotelRank;
  }

  private int calculateReviewRank(Set<String> keys, String review)
  {
    int rank = 0;
    String[] tokens = review.toLowerCase().split("[ \\.,!]");

    for (String token : tokens)
    {
      if (keys.contains(token))
      {
        rank++;
      }
    }

    return rank;
  }

  private Map<Integer, Set<Integer>> sortByRank(Map<Integer, Integer> idToRankMap)
  {
    Map<Integer, Set<Integer>> rankToIdMap = new TreeMap<>();

    for (Integer id : idToRankMap.keySet())
    {
      Integer rank = idToRankMap.get(id);

      Set<Integer> ids = rankToIdMap.computeIfAbsent(rank, k -> new TreeSet<>());
      ids.add(id);
    }

    return rankToIdMap;
  }


  public static void main(String[] args)
  {
    Map<Integer, Set<Integer>> rankMap = new HotelRankCalculator().calculate(createKeys(), createReviews());

    for(Map.Entry<Integer, Set<Integer>> e : rankMap.entrySet())
    {
      System.out.printf("Hotels with rank %d : %s\n", e.getKey(), e.getValue());
    }
  }

    private static Map<Integer, List<String>> createReviews()
    {
        Map<Integer, List<String>> reviewMap = new HashMap<>();

        List<String> hotel1Reviews = new ArrayList<>();
        hotel1Reviews.add("The breakfast is ok. Regarding location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
        hotel1Reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter");

        List<String> hotel2Reviews = new ArrayList<>();
        hotel2Reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
        hotel2Reviews.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
        hotel2Reviews.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");

        List<String> hotel3Reviews = new ArrayList<>();
        hotel3Reviews.add("price price price price price price");

        reviewMap.put(1, hotel1Reviews);
        reviewMap.put(2, hotel2Reviews);
        reviewMap.put(3, hotel3Reviews);
        return reviewMap;
    }

    private static Set<String> createKeys()
    {
        Set<String> keys = new HashSet<>();
        keys.add("breakfast");
        keys.add("beach");
        keys.add("citycenter");
        keys.add("location");
        keys.add("metro");
        keys.add("view");
        keys.add("staff");
        keys.add("price");
        return keys;
    }
}
