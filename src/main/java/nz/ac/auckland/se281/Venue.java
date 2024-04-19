package nz.ac.auckland.se281;

// created new class named venue
public class Venue {
  private String venueName;
  private String venueCode;
  private String capacity;
  private String hireFee;

  // setting input to my private variables using 'this'
  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = capacityInput;
    this.hireFee = hireFeeInput;
  }

  // setting all my getters to be used inside print venues and create venues
  public String getVenueName() {
    return venueName;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getCapacity() {
    return capacity;
  }

  public String getHireFee() {
    return hireFee;
  }
}
