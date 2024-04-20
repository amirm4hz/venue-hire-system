package nz.ac.auckland.se281;

import java.util.List;

public abstract class Services {

  protected List<Bookings> bookings;

  public Services(List<Bookings> bookings) {
    this.bookings = bookings;
  }

  public boolean doesBookingExist(String bookingReference) {
    for (Bookings booking : bookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        return true;
      }
    }
    return false;
  }
}
