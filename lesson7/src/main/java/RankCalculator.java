import java.util.*;

public class RankCalculator
{
  public Map<Integer, Set<Integer>> calculateRank(Set<String> keys, Map<Integer, List<String>> reviewMap)
  {
    Map<Integer, Integer> idToRankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : reviewMap.entrySet())
    {
      ReviewSplit ( keys , idToRankMap , entry );
    }

    return sortByRank(idToRankMap);
  }

  private void ReviewSplit(Set<String> keys , Map<Integer, Integer> idToRankMap , Map.Entry<Integer, List<String>> entry)
  {
    Integer hotelId = entry.getKey();

    for (String review : entry.getValue())
    {
      String[] tokens = review.toLowerCase().split("[ \\.,!]");

      RankIncrementation ( keys , idToRankMap , hotelId , tokens );
    }
  }

  private void RankIncrementation(Set<String> keys , Map<Integer, Integer> idToRankMap , Integer hotelId , String[] tokens)
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