import java.util.*;
import java.util.TreeSet;
import java.lang.Integer;
public class Rank
{  public Map RankCalculate(Map<Integer, List<String>> ReviewsMap , Set<String> SearchKeys)
{
  Map<Integer, Integer> IdtoRank = new HashMap<> ( );
  for ( Map.Entry<Integer, List<String>> entry : ReviewsMap.entrySet ( ) )
  {
    int hotelId = entry.getKey ( );
    for ( String review : entry.getValue ( ) )
    {
      String[] ReviewtoWords = review.toLowerCase ( ).split ( "[ \\.,!]" );
      for ( String word : ReviewtoWords )
      {
        for ( String key : SearchKeys )
        {
          if (word.contains ( key ))
          {
            Integer rank = IdtoRank.get ( hotelId );
            if (rank == null)
            {
              rank = 0;
            }

            IdtoRank.put ( hotelId , rank + 1 );
          }
        }
      }
    }
  }
  return SortbyRank(IdtoRank);
}


  Map<Integer, Set<Integer>> SortbyRank(Map<Integer, Integer> idToRankMap)
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