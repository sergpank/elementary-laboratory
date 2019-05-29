package exercise25;
import java.util.*;

public class RankCalculator
{
  public Map<Integer, Set<Integer>> calculateRank(Set<String> keys, Map<Integer, List<String>> reviewMap) // принимает ключевые слова и
  {                                                                                                       // сами отели
    Map<Integer, Integer> idToRankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : reviewMap.entrySet())   // пробегаем по каждому отелю
    {
      Integer hotelId = entry.getKey();  // получаем ID отеля

      for (String review : entry.getValue()) // пробегаем по всем отзывам
      {
        String[] tokens = review.toLowerCase().split("[ \\.,!]"); // разбиваем каждый отзыв на массив слов
        for (String token : tokens) // пробегаем по каждому слову
        {
          if (keys.contains(token))  // если слово есть среди ключей увеличиваем ранг на 1
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
    }

    return sortByRank(idToRankMap);
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