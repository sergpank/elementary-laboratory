import java.util.ArrayList;
import java.util.List;

public class Main
{
  public static void main(String[] args)
  {

    List<String> key = new ArrayList<String>();
    key.add("breakfast");
    key.add("beach");
    key.add("citycenter");
    key.add("location");
    key.add("metro");
    key.add("view");
    key.add("staff");
    key.add("price");

    Hotel hotel = new Hotel("BlackSea");
    hotel.addReview("The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    hotel.addReview("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter");

    Hotel hotel1 = new Hotel("Zirka");
    hotel1.addReview("This hotel has a nice view of the citycenter. " +
        "The location is perfect.");
    hotel1.addReview("Location is excellent, 5 min from citycenter. " +
        "There is also a metro station pretty close to the hotel.");
    hotel1.addReview("They said I couldn't take my dog. " +
        "But there were other guests with dogs! That is not fair.");

    Booking booking = new Booking(key);

    booking.addHotel(hotel);
    booking.addHotel(hotel1);
    booking.showRelHotel();


  }
}
