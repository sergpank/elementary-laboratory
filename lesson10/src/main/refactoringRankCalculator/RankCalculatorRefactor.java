package main.refactoringRankCalculator;

import java.util.*;

public class RankCalculatorRefactor
{
  public static void main(String[] args)
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

    Map<Integer, List<String>> reviewMap = createData();

    RankCalculatorRefactor rankCalculator = new RankCalculatorRefactor();

    Map<Integer, Set<Integer>> rankMap = rankCalculator.calculateRank(keys, reviewMap);

    for(Map.Entry<Integer, Set<Integer>> e : rankMap.entrySet())
    {
      System.out.printf("Hotels with rank %d : %s\n", e.getKey(), e.getValue());
    }

  }

  private static Map<Integer, List<String>> createData()
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

  public Map<Integer, Set<Integer>> calculateRank(Set<String> keys, Map<Integer, List<String>> reviewMap)
  {
    Map<Integer, Integer> idToRankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : reviewMap.entrySet())
    {
      splitToTokens(keys, idToRankMap, entry);
    }

    return sortByRank(idToRankMap);
  }

  public void splitToTokens(Set<String> keys, Map<Integer, Integer> idToRankMap, Map.Entry<Integer, List<String>> entry)
  {
    Integer hotelId = entry.getKey();
    for (String review : entry.getValue())
    {
      String[] tokens = review.toLowerCase().split("[ \\.,!]");
      analyzeReview(keys, idToRankMap, hotelId, tokens);
    }
  }

  public void analyzeReview(Set<String> keys, Map<Integer, Integer> idToRankMap, Integer hotelId, String[] tokens)
  {
    for (String token : tokens)
    {
      if (keys.contains(token))
      {
        Integer rank = idToRankMap.get(hotelId);

        if (rank == null)
        {
          rank = 0;
        }

        idToRankMap.put(hotelId, rank + 1);
      }
    }
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
}
