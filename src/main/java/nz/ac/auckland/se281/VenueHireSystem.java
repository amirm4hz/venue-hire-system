package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private String setDate = "";
  private List<Venue> venues;

  public VenueHireSystem() {
    this.venues = new ArrayList<>();
  }

  // logic for print venues
  public void printVenues() {
    // return from isempty so that for loop is skipped and venue names dont print
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
    // for loop to print out all venues on the array list if venues is not empty
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
        // example: if the size of the array is 2 that will be input for intToString function
        // then go to case 2 and return the word "two" and that will be input for messagecli
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
    this.setDate = dateInput; // this is setting the initialised date to the input date
    MessageCli.DATE_SET.printMessage(setDate);
  }

  public void printSystemDate() {
    if (!this.setDate.isEmpty()) { // if date been set by user this statement will pass
      MessageCli.CURRENT_DATE.printMessage(setDate);
    } else { // if date has not been set this print statement will return
      System.out.println("Current system date is not set.");
    }
  }

  public void makeBooking(String[] options) {

    boolean venueNotFound = true;
    String venueName = "";

    if (setDate.isEmpty()) { // check if date has been set
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }
    if (venues.isEmpty()) { // check if there are any venues in the system
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }
    for (Venue venue : venues) { // check if venue code exists in the system
      if (venue.getVenueCode().equals(options[0])) {
        venueNotFound = false;
        venueName = venue.getVenueName();
        break;
      }
    }
    if (venueNotFound) { // if venue code does not exist in the system
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      return;
    }

    String[] dateParts = options[1].split("/"); // split the input date into day month year
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);

    String[] dateNewParts = setDate.split("/"); // split the system date into day month year
    int dayNow = Integer.parseInt(dateNewParts[0]);
    int monthNow = Integer.parseInt(dateNewParts[1]);
    int yearNow = Integer.parseInt(dateNewParts[2]);

    if (year < yearNow) { // check if the year is in the past
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], setDate);
      return;
    }
    if (year == yearNow && month < monthNow) { // if year is the same check if month is in the past
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], setDate);
      return;
    }
    if (year == yearNow
        && month == monthNow
        && day < dayNow) { // if year and month are the same check if day is in the past
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], setDate);
      return;
    }
    for (Venue venue : venues) {
      if (venue.getVenueCode().equals(options[0])) {
        if (Integer.parseInt(venue.getCapacity()) < Integer.parseInt(options[3])) {
          MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
              options[3], venue.getCapacity(), venue.getCapacity());
          options[3] = venue.getCapacity();
          break;
        }
        if (Integer.parseInt(venue.getCapacity()) < (Integer.parseInt(options[3]) / 4)) {
          MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
              options[3], intToString((Integer.parseInt(options[3]) / 4)), venue.getCapacity());
          options[3] = intToString((Integer.parseInt(options[3]) / 4));
          break;
        }
      }
    }

    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        BookingReferenceGenerator.generateBookingReference(), venueName, options[1], options[3]);
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
