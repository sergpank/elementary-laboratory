import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

public class Booking
{

  public static void main(String[] args)
  {
    ArrayList<String> Reviews1 = new ArrayList<> ( );
    Reviews1.add ( "This hotel has a nice view of the citycenter. The location is perfect." );
    Reviews1.add ( "Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel." );
    Reviews1.add ( "They said I couldn't take my dog . But there were other guests with dogs! That is not fair." );

    ArrayList<String> Reviews2 = new ArrayList<> ( );
    Reviews2.add ( "The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok." );
    Reviews2.add ( "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter." );


    ArrayList<String> KeyWordList = new ArrayList<> ( );
    KeyWordList.add ( "breakfast" );
    KeyWordList.add ( "beach" );
    KeyWordList.add ( "citycenter" );
    KeyWordList.add ( "location" );
    KeyWordList.add ( "metro" );
    KeyWordList.add ( "view" );
    KeyWordList.add ( "staff" );
    KeyWordList.add ( "price" );

    Map<Integer, ArrayList> Hotels = new HashMap<> ( );
    Hotels.put ( 1 , Reviews1 );
    Hotels.put ( 2 , Reviews2 );


    String[] KeyWords = ListToArray ( KeyWordList );

    ArrayList firstReviewList = Hotels.get ( 1 );
    String[] FirstReviews = ListToArray ( firstReviewList );

    ArrayList secondReviewList = Hotels.get ( 2 );
    String[] SecondReviews = ListToArray ( secondReviewList );

    int firstRating = ratingCalculate ( FirstReviews , KeyWords );
    int secondRating = ratingCalculate (SecondReviews, KeyWords);


    Map<Integer, Integer> Ratings = new HashMap<> ( );
    Ratings.put ( 1 , firstRating );
    Ratings.put ( 2 , secondRating );

    //RatingsSort(Ratings);


    //сортировка
/*    Set<Integer> keys = Ratings.keySet();
    Integer [] Ratio = new Integer [keys.size ( )];
    for (int i=1; i<keys.size (); i++)
    {
      Ratio [i] = (Integer) Ratings.get ( i );
      System.out.println ( Ratio[i] );
    }


    Arrays.sort(Ratio);




    for (Object o : Ratings.keySet())
    {
      for ( int i = 0 ; i < Ratio.length ; i++ )
      {
        if (((Integer) Ratings.get ( o )).equals ( Ratio[i] ))
        {
          System.out.println ( o );
        }
      }


    }*/
  }


  public static int ratingCalculate(String[] Reviews , String[] KeyWords)
  {

    int rating = 0;
    for ( int i = 0 ; i < Reviews.length ; i++ )
    {
      System.out.println ( Reviews[i] );
      //System.out.println (  );
      String[] Words = Reviews[i].split ( " " );

      for ( int j = 0 ; j < Words.length ; j++ )
      {
        for ( int k = 0 ; k < KeyWords.length ; k++ )
        {
          if (Words[j].toLowerCase ( ).contains ( KeyWords[k].toLowerCase ( ) ))
          {
            rating++;
          }
        }
      }
    }
    System.out.println ( rating );
    return rating;
  }


  public static String[] ListToArray(ArrayList ReviewList)
  {
    String[] ReviewsArray = new String[ReviewList.size ( )];
    int index = 0;
    for ( Object value : ReviewList )

    {
      ReviewsArray[index] = (String) value;
      index++;
    }
    return ReviewsArray;
  }

/*public static void RatingsSort (Map Ratings)
{
  Set<Integer> keys = Ratings.keySet();
  Integer [] Ratio = new Integer [keys.size ( )];
  for (int i=0; i<keys.size (); i++)
  {
    Ratio [i] = (Integer) Ratings.get ( i );
  }


  Arrays.sort(Ratio);




    for (Object o : Ratings.keySet())
    {
      for ( int i = 0 ; i < Ratio.length ; i++ )
      {
        if (((Integer)Ratings.get ( o )).equals ( Ratio[i] ))
        {
          System.out.println ( o );
        }
      }
    }

}*/



}



