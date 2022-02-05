package Controller;

import Exceptions.NoSeatsAvailableException;
import ModelView.Operation;
import ModelView.Theater;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reservation service class is the controller for the booking process. It handles all the
 * interaction between user and the system and help update the theater model and view after each
 * successful booking.
 */
public class ReservationService {

  private static final String WHAT_TO_DO = "What would you like to do?";
  private static final String WHAT_NAME = "What's your name?";
  private static final String APOLOGIZE = "Sorry, we don't have that many seats together for you.";
  private static final String NEED_WHEELCHAIR_PROMPT = "Do you need wheelchair accessible seats?";
  private static final String DONE_STRING = "done";
  private static final String SHOW_STRING = "show";
  private static final String RESERVE_STRING = "reserve";
  private static final String YES_RESPONSE = "yes";
  private static final String NO_RESPONSE = "no";
  private static final String EXCEEDING_ROW_CAPACITY_MESSAGE = "The maximum capacity per row are %d people, please try again!";
  private static final String NUM_OF_PEOPLE_MESSAGE = "The number of people need to be greater than 0 and less than %d.";
  private static final String RESPONSE_HINT = "Please answer yes or no to the above question.";
  private static final String NICE_DAY = "Have a nice day!";
  private static final String ILLEGAL_NAME_MESSAGE = "Please provide a legal English name.";
  private static final String CONFIRMATION_STRING_FIRST_HALF = "I've reserved %d seats for you at the ";
  private static final String CONFIRMATION_STRING_SECOND_HALF = " in row, %d, ";
  private static final String NAME_MATCHER_REGEX = "([A-Za-z']+).*";
  private static final String USAGE_MESSAGE =
      "Please enter using the following command: " + System.lineSeparator()
          + "\"reserve <number>\" to reserve that number of seats." + System.lineSeparator() +
          "\"show\" to display the current available seating in the theater."
          + System.lineSeparator() + "\"done\" to shut down the system.";
  private static final int NO_ARG_LENGTH = 0;
  private static final int SINGLE_ARG_LENGTH = 1;
  private static final int MAX_ARG_LENGTH = 2;

  private final Theater theater;

  /**
   * Constructor to create a service object given the specific theater.
   *
   * @param theater - ModelView.Theater, the given theater used in the booking process.
   */
  public ReservationService(Theater theater) {
    this.theater = theater;
  }

  /**
   * Determine whether the user request a wheelchair row or not.
   *
   * @param scanner - Scanner, the scanner to get user input.
   * @return whether the user request a wheelchair.
   */
  private boolean needWheelchairRow(Scanner scanner) {
    System.out.println(NEED_WHEELCHAIR_PROMPT);
    while (true) {
      String wheelchairResponse = scanner.nextLine().trim().toLowerCase();
      if (!(wheelchairResponse.equals(YES_RESPONSE) || wheelchairResponse.equals(NO_RESPONSE))) {
        System.out.println(RESPONSE_HINT);
      } else {
        return wheelchairResponse.equals(YES_RESPONSE);
      }
    }
  }

  /**
   * Getter for theater.
   * @return the theater tied to this reservation system.
   */
  public Theater getTheater() {
    return theater;
  }

  /**
   * Get the name of the user reserving the seats.
   *
   * @param scanner - Scanner, the scanner to get user input.
   * @return the name of the user as a string.
   */
  private String reservedForWho(Scanner scanner) {
    System.out.println(WHAT_NAME);
    String reservedFor;
    while (true) {
      String possibleReservedFor = scanner.nextLine().trim();
      reservedFor = processReservedFor(possibleReservedFor);
      if (reservedFor == null) {
        printIllegalNameMessage();
        continue;
      }
      return reservedFor;
    }
  }

  /**
   * Update the theater seating based on the user input.
   *
   * @param numOfPeople       - int, the number of people per reservation.
   * @param reservedFor       - String, the user's name.
   * @param needWheelchairRow - boolean, whether wheelchair row is required.
   */
  public void updateTheaterWithUserInfoAndDisplay(int numOfPeople, String reservedFor,
      boolean needWheelchairRow) {
    try {
      int optimalRow = theater.changeSeatsToOccupied(numOfPeople, reservedFor, needWheelchairRow);
      printConfirmation(numOfPeople, theater.getName(), optimalRow, reservedFor);
      theater.show();
    } catch (NoSeatsAvailableException nsae) {
      printApology();
    }
  }

  /**
   * Process the user input in an interactive way.
   */
  public void process() {
    Scanner scanner = new Scanner(System.in);

    boolean running = true;
    int rowCapacity = theater.getRowCapacity();
    while (running) {

      /*
      First, ask what the user want to do. If the user input illegal request, print a usage message
      to hint the user what the system can do. If the user want reserve, save the number of people.
      If the user want to show the current seating, show the theater seating. If the user want to
      complete the booking process, change the running variable to false so to break out of the infinite
      while loop.
       */
      System.out.println(WHAT_TO_DO);
      int numOfPeople = 0;
      try {
        String nextLine = scanner.nextLine().trim();
        String[] splitLine = nextLine.split(" ");
        Operation op = getOperation(nextLine);
        switch (op) {
          case DONE:
            running = false;
            System.out.println(NICE_DAY);
            scanner.close();
            printSeparationLine();
            return;
          case SHOW:
            theater.show();
            printSeparationLine();
            continue;
          case RESERVE:
            numOfPeople = Integer.parseInt(splitLine[1]);
            if (numOfPeople <= 0) {
              System.out.printf((NUM_OF_PEOPLE_MESSAGE) + System.lineSeparator(), rowCapacity);
              printSeparationLine();
              continue;
            } else if (numOfPeople > rowCapacity) {
              System.out.printf((EXCEEDING_ROW_CAPACITY_MESSAGE) + System.lineSeparator(),
                  rowCapacity);
              printSeparationLine();
              continue;
            }
        }
      } catch (IllegalArgumentException iae) {
        printUsageMessage();
        continue;
      }

      /*
      Ask if the user need wheelchair accessible row. If the user input something other than yes or
      no, hint the user about how to use the function and allow the user to input again. Otherwise,
      record the user's response to be used later.
       */
      boolean needWheelchairRow = needWheelchairRow(scanner);

      /*
      Ask for the name of the user so that the system knows who the seats are reserved for. If the
      user input something other than legal english character, ignore the illegal character and only
      retrieve the english character in it. However, if the user input a complete illegal character
      sequence, hint the user how to use it and allow the user to input again.
       */
      String reservedFor = reservedForWho(scanner);

      /*
      Process the user response based on the request and book the seats in the theater. If the booking
      process could not be completed, print an apology message and ask the user to try again.
       */
      updateTheaterWithUserInfoAndDisplay(numOfPeople, reservedFor, needWheelchairRow);

      printSeparationLine();
    }
  }

  /**
   * Get the type of operation the user want to command, which include reserve, done, and show.
   *
   * @param operationLine - The line containing the user input.
   * @return The type of operation the user want to command.
   * @throws IllegalArgumentException If the command is not within the above three commands, or if
   *                                  the command is reserve but the number is not correct.
   */
  public Operation getOperation(String operationLine) throws IllegalArgumentException {
    String[] splitLine = operationLine.split(" ");
    int length = splitLine.length;
    if (length <= NO_ARG_LENGTH || length > MAX_ARG_LENGTH) {
      throw new IllegalArgumentException();
    } else if (length == SINGLE_ARG_LENGTH) {
      if (splitLine[0].equals(SHOW_STRING)) {
        return Operation.SHOW;
      } else if (splitLine[0].equals(DONE_STRING)) {
        return Operation.DONE;
      } else {
        throw new IllegalArgumentException();
      }
    } else {
      try {
        Integer.parseInt(splitLine[1]);
      } catch (NumberFormatException nfe) {
        throw new IllegalArgumentException();
      }
      if (splitLine[0].equals(RESERVE_STRING)) {
        return Operation.RESERVE;
      } else {
        throw new IllegalArgumentException();
      }
    }
  }

  /**
   * Print the illegal name message.
   */
  private void printIllegalNameMessage() {
    System.out.println(ILLEGAL_NAME_MESSAGE);
  }

  /**
   * Process the username using the regular expression matching.
   *
   * @param reservedForLine - The line containing user's name.
   * @return - The user's name or null if the username is not an English sequence.
   */
  private String processReservedFor(String reservedForLine) {
    Pattern p = Pattern.compile(NAME_MATCHER_REGEX);
    Matcher m = p.matcher(reservedForLine);
    if (m.find()) {
      return m.group(1);
    }
    return null;
  }

  /**
   * Print the usage message for the command.
   */
  private void printUsageMessage() {
    System.out.println(USAGE_MESSAGE);
    printSeparationLine();
  }

  /**
   * Print the apology message.
   */
  private void printApology() {
    System.out.println(APOLOGIZE);
    printSeparationLine();
  }

  /**
   * Print a separation empty line.
   */
  private void printSeparationLine() {
    System.out.println();
  }

  /**
   * Print the confirmation message after the user successfully book seats in the theater.
   *
   * @param numOfPeople - int, number of people.
   * @param theaterName - String, theater name.
   * @param row         - int, row number for the booking.
   * @param reservedFor - String, the name of the user who reserve the seats.
   */
  private void printConfirmation(int numOfPeople, String theaterName, int row, String reservedFor) {
    System.out.println(
        String.format(CONFIRMATION_STRING_FIRST_HALF, numOfPeople) + theaterName
            + String.format(CONFIRMATION_STRING_SECOND_HALF, row) + reservedFor + ".");
  }
}
