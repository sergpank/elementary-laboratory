import java.util.*;

public class Rank
{
  public Map RankCalculate(Map<Integer, List<String>> ReviewsMap , Set<String> SearchKeys)
  {
    Map<Integer, Integer> IdtoRank = new HashMap<> ( ); //создали карту для наших айди и оценки
    for ( Map.Entry<Integer, List<String>> entry : ReviewsMap.entrySet ( ) ) //получаем значение ключа и значения из нашей карты
    {
      int hotelId = entry.getKey ( ); //номера отелей записали, потом они будут в новой мапе
      for ( String review : entry.getValue ( ) ) //вытянули значения
      {
        String[] ReviewtoWords = review.toLowerCase ( ).split ( "[ \\.,!]" ); //заполняем массив словами, разделительными знаками и пробелом (по каждой строке и разбиваем, так все строки)
        for ( String word : ReviewtoWords ) //идём по массиву слов
        {
          for ( String key : SearchKeys ) //идём по списку ключевых слов
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
