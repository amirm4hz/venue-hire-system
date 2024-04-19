package nz.ac.auckland.se281;

public class Bookings {
  private String bookingReference;
  private String email;
  private String bookingDate;
  private String numberOfGuests;
  private String venueCode;

  public Bookings(
      String bookingReference,
      String email,
      String bookingDate,
      String numberOfGuests,
      String venueCode) {
    this.bookingReference = bookingReference;
    this.email = email;
    this.bookingDate = bookingDate;
    this.numberOfGuests = numberOfGuests;
    this.venueCode = venueCode;
  }

  public String getVenueCode() {
    return venueCode;
  }

  // returns the booking reference
  public String getBookingReference() {
    return bookingReference;
  }

  // returns the booking date
  public String getBookingDate() {
    return bookingDate;
  }

  // returns the number of attenedees "guests"
  public String getNumberOfGuests() {
    return numberOfGuests;
  }

  // returns the email of the customer
  public String getEmail() {
    return email;
  }
}
