import java.util.*;

public class RankCalculator
{
  Set<String> keySet = new HashSet<>();
  Map<Integer, List<String>> hotelReviewsMap = new HashMap<>();
  Map<Integer, List<Integer>> hotelReviewRank = new HashMap<>();

  public void go()
  {
    addKeySet();
    addHotelReviewsMap();
    calculateRank();
    sortByRank();
  }

  private void addKeySet()
  {

    keySet.add("breakfast");
    keySet.add("beach");
    keySet.add("citycenter");
    keySet.add("location");
    keySet.add("metro");
    keySet.add("view");
    keySet.add("staff");
    keySet.add("price");
  }

  private void addHotelReviewsMap()
  {
    List<String> hotel1Reviews = new ArrayList<>(
        Arrays.asList(
            "1 The breakfast is ok. Regarding location, it is quite fat from the citycenter. But price is cheap, so it is ok.",
            "1 Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter"
        )
    );


    List<String> hotel2Reviews = new ArrayList<>(
        Arrays.asList(
            "2 This hotel has a nice view of the citycenter. The location is perfect.",
            "2 Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.",
            "2 They said I couldn't take my dog. But there were other guests with dogs! That is not fair."
        )
    );


    List<String> hotel3Reviews = new ArrayList<>(
        Arrays.asList(
            "3 price price price price price price"
        )
    );


    hotelReviewsMap.put(1, hotel1Reviews);
    hotelReviewsMap.put(2, hotel2Reviews);
    hotelReviewsMap.put(3, hotel3Reviews);
  }

  private void calculateRank()
  {
    for (Map.Entry<Integer, List<String>> entry : hotelReviewsMap.entrySet())
    {
      Integer id = entry.getKey();
      Integer sumRank = 0;

      for (String review : entry.getValue())
      {
        sumRank = sumRank + calcRankByReview(review);
      }
      hotelReviewRank.computeIfAbsent(sumRank, i -> new ArrayList<>()).add(id);
    }
  }

  private Integer calcRankByReview(String review)
  {
    String[] tokens = review.toLowerCase().split(" ");
    Integer id = Integer.parseInt(tokens[0]);
    Integer counter = 0;
    for (String token : tokens)
    {
      for (String key : keySet)
      {
        if (token.contains(key))
        {
          counter++;
        }
      }
    }
    return counter;

  }

  private void sortByRank()
  {
    Map<Integer, List<Integer>> rankHotelMap = new TreeMap<>(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o2.compareTo(o1);
      }
    });

    rankHotelMap.putAll(hotelReviewRank);

    System.out.println(rankHotelMap);
  }
}


