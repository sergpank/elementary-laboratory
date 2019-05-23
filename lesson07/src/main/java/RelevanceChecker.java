import java.util.*;

public class RelevanceChecker
{
  private Map<Integer, List<String>> ReviewsMap = addReviews();
  private Set<String> keys = new HashSet<>();

  {
    keys.add("breakfast");
    keys.add("beach");
    keys.add("citycenter");
    keys.add("location");
    keys.add("metro");
    keys.add("view");
    keys.add("staff");
    keys.add("price");
  }


  private Map addReviews()
  {
    Map<Integer, List<String>> ReviewsMap = new HashMap<>();

    List<String> hotel1Reviews = new ArrayList<>();
    hotel1Reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
    hotel1Reviews.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    hotel1Reviews.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");

    List<String> hotel2Reviews = new ArrayList<>();
    hotel2Reviews.add("The breakfast is ok. Regarding location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    hotel2Reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter");


    ReviewsMap.put(1, hotel1Reviews);
    ReviewsMap.put(2, hotel2Reviews);
    return ReviewsMap;
  }


  public static void main(String[] args)
  {
    RelevanceChecker ch = new RelevanceChecker();

    System.out.println(ch.calcMostRelevantID());

  }

  private Map calcMostRelevantID()
  {
    Map<Integer, Integer> rankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : ReviewsMap.entrySet())
    {
      Integer hotelID = entry.getKey();

      for (String review : entry.getValue())
      {
        String[] splitReview = review.split("[\\s\\W]");
        for (String words : splitReview)
        {

          if (keys.contains(words))
          {   //применять contains вместо equals();

            Integer rank = rankMap.get(hotelID);
            if (rank == null)
            {
              rank = 0;
            }
            rankMap.put(hotelID, rank + 1);

          }

        }


      }

    }

    return sortByRank(rankMap);

  }


  private Map<Integer, Set<Integer>> sortByRank(Map<Integer, Integer> rankMap)
  {
    Map<Integer, Set<Integer>> sortedMap = new TreeMap<>(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o2-o1;
      }
    });

    for (Integer id : rankMap.keySet())
    {
      Integer rank = rankMap.get(id);

      //Set<Integer> ids = sortedMap.computeIfAbsent(rank, x -> new TreeSet<>());

      Set<Integer> ids = sortedMap.get(rank);

      if (ids == null)
      {
        ids = new TreeSet<>();

      }

      sortedMap.put(rank,ids);

      ids.add(id);

    }

    return sortedMap;


  }


}//end
