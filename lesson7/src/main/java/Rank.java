import java.util.*;

public class Rank
{
  public Map RankCalculate(Map<Integer, List<String>> ReviewsMap , Set<String> SearchKeys)
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

    return IdtoRank;
  }


  public Map SortbyRank(Map<Integer, Integer> IdtoRank)
  {
    Map<Integer, Integer> RanktoId = new TreeMap<> ( new Comparator<Integer> ( )
    {
      @Override
      public int compare(Integer rank1 , Integer rank2)
      {
        return rank2-rank1;
      }
    } );

    for ( Integer id : IdtoRank.keySet ( ) )
    {
      int rank = IdtoRank.get ( id );
      RanktoId.put ( rank , id );


    }

    return RanktoId;
  }


}