package homework21;

public class DisplayBooking
{
  public static void main(String[] str)
  {

    Booking booking = new Booking();
    booking.addHotel(new Hotel("Hotel A"));
    booking.addHotel(new Hotel("Hotel B"));
    booking.addHotel(new Hotel("Hotel C"));

    booking.addKeyword("breakfast");
    booking.addKeyword("beach");
    booking.addKeyword("citycenter");
    booking.addKeyword("location");
    booking.addKeyword("metro");
    booking.addKeyword("view");
    booking.addKeyword("staff");
    booking.addKeyword("price");

    booking.addReview(1,
        "This hotel has a nice view of the citycenter. The location is perfect.");
    booking.addReview(1,
        "Location is excellent, 5 min from citycenter. " +
            "There is also a metro station pretty close to the hotel.");
    booking.addReview(1, "They said I couldn't take my dog. " +
        "But there were other guests with dogs! That is not fair.");
    booking.addReview(2, "The breakfast is ok. Regaring location, " +
        "it is quite fat from the citycenter. But price is cheap, so it is ok.");
    booking.addReview(2, "Very friendly staff and " +
        "good cost-benefit ratio. Its location is a bit far from citycenter.");

    booking.addReview(3,
        "This hotel has a nice view of the citycenter. The location is perfect.");
    booking.addReview(3,
        "Location is excellent, 5 min from citycenter. " +
            "There is also a metro station pretty close to the hotel.");
    booking.addReview(3, "They said I couldn't take my dog. " +
        "But there were other guests with dogs! That is not fair.");
    // booking.addReview(3, "The breakfast is ok. Regaring location, "+
    //     "it is quite fat from the citycenter. But price is cheap, so it is ok.");
    // booking.addReview(3,"Very friendly staff and "+
    //     "good cost-benefit ratio. Its location is a bit far from citycenter." );

    System.out.println("Не упорядоченный список отелей");
    for (Hotel item : booking.getHotels())
    {
      System.out.println(item + " relevance: " + booking.getRelevance(item));
    }
    System.out.println();

    System.out.println("Упорядоченный по релевантности список отелей");
    for (Hotel item : booking.getHotelsByRelevance())
    {
      System.out.println(item+ " relevance: " + booking.getRelevance(item));
    }

//    booking.addKeyword("citycenter");
//    System.out.println();
//    System.out.println("Упорядоченный по релевантности список отелей");
//    for (Hotel item : booking.getHotelsByRelevance())
//    {
//      System.out.println(item+ " relevance: " + booking.getRelevance(item));
//    }

    System.out.println();
    booking.deleteHotel(1);

    for (Hotel item : booking.getHotelsByRelevance())
    {
      System.out.println(item);
    }

  }
}
