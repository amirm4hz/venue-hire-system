package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  public class Venue {
    private String venueName;
    private String venueCode;
    private String capacity;
    private String hireFee;

    public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
      this.venueName = venueName;
      this.venueCode = venueCode;
      this.capacity = capacityInput;
      this.hireFee = hireFeeInput;
    }

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

  private List<Venue> venues;

  public VenueHireSystem() {
    this.venues = new ArrayList<>();
  }

  public void printVenues() {
    if (venues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    } else if (venues.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    } else if (venues.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", intToString(venues.size()), "");
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venues.size()), "");
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    if (venueName.trim().isBlank()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }
    for (Venue existingVenues : venues) {
      if (existingVenues.getVenueCode().equals(venueCode)) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
            venueCode, existingVenues.getVenueName());
        return;
      }
    }
    if (Integer.parseInt(capacityInput) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(capacityInput, " positive");
      return;
    }
    if (!capacityInput.matches("\\d+")) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(capacityInput);
      return;
    }
    if (Integer.parseInt(hireFeeInput) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(hireFeeInput, " positive");
      return;
    }
    if (!hireFeeInput.matches("\\d+")) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(hireFeeInput);
      return;
    }

    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venues.add(newVenue);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    for (Venue printVenues : venues) {
      MessageCli.VENUE_ENTRY.printMessage(
          printVenues.getVenueName(),
          printVenues.getVenueCode(),
          printVenues.getCapacity(),
          printVenues.getHireFee());
    }
  }

  public String intToString(int num) {
    switch (num) {
      case 2:
        return "two";
      case 3:
        return "three";
      case 4:
        return "four";
      case 5:
        return "five";
      case 6:
        return "six";
      case 7:
        return "seven";
      case 8:
        return "eight";
      case 9:
        return "nine";
      default:
        return "invalid";
    }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
