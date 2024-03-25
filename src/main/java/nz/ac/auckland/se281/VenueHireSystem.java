package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private List<VenueHireSystem> venues;
  private String venueName;
  private String venueCode;
  private String capacity;
  private String hireFee;

  public VenueHireSystem() {
    this.venues = new ArrayList<>();
  }

  public void printVenues() {
    if (venues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = capacityInput;
    this.hireFee = hireFeeInput;

    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    for (VenueHireSystem existingVenues : venues) {
      if (existingVenues.venueCode == venueCode) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, existingVenues.venueName);
      }
    }
    if (Integer.parseInt(capacity) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(capacity, "positive");
    }
    if (capacity.matches("\\d")) {
    } else {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(capacity);
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
