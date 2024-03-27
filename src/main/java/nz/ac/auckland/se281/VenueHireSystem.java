package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

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

  private List<Venue> venues;

  public VenueHireSystem() {
    this.venues = new ArrayList<>();
  }

  // logic for print venues
  // return from isempty so that for loop is skipped and venue names dont print
  public void printVenues() {
    if (venues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
      return;
    } else if (venues.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    } else if (venues.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", intToString(venues.size()), "s");
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venues.size()), "s");
    }
    for (Venue printVenues : venues) {
      MessageCli.VENUE_ENTRY.printMessage(
          printVenues.getVenueName(),
          printVenues.getVenueCode(),
          printVenues.getCapacity(),
          printVenues.getHireFee());
    }
  }

  // method for create venues
  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    // remove spaces and if venue name is blank print empty name
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
    // parsing string capacity input as an integer and testing to see if valid integer
    int capacity;
    try {
      capacity = Integer.parseInt(capacityInput);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }
    // checking if capacity int is less than zero (first check if its valid integer)
    if (capacity < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      return;
    }
    // again parsing string hire fee input as an integer and testing for validity
    int hireFee;
    try {
      hireFee = Integer.parseInt(hireFeeInput);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }
    // checking if hire fee is less than 0 (first checking to see if its a valid integer)
    if (hireFee < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
      return;
    }
    // if everything is valid and passes all tests it will not leave the method
    // once reached here new venue is added to the array list and prints success message
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venues.add(newVenue);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  // switch case to convert the size of the venue list if its between 2-9 to word form
  // this reduces the code in print venues making it easier to read
  // this method takes int input of list size from print venues and returns word
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
