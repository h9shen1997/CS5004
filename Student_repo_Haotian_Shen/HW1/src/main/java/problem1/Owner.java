package problem1;

/**
 * Owner is a simple object that has a first name, a last name, and a phone number.
 */
public class Owner {

  private String firstName;
  private String lastName;
  private String phoneNumber;

  /**
   * Constructor that creates a new Owner with the specified first name, last name and phone
   * number.
   *
   * @param firstName   - first name of the new Owner.
   * @param lastName    - last name of the new Owner.
   * @param phoneNumber - phone number of the new Owner.
   */
  public Owner(String firstName, String lastName, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns the first name of the Owner.
   *
   * @return the first name of the Owner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the Owner with the specified first name.
   *
   * @param firstName - the new first name for the Owner.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns the last name of the Owner.
   *
   * @return the last name of the Owner.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the Owner with the specified last name.
   *
   * @param lastName - the new last name of the Owner.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Returns the phone number of the Owner.
   *
   * @return the phone number of the Owner.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Set the phone number of the Owner with the specified new phone number.
   *
   * @param phoneNumber - the new phone number of the Owner.
   * @throws IllegalArgumentException if the phone number is not 10-digit and contains characters
   *                                  other than numbers.
   */
  public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
    if (phoneNumber.length() != 10) {
      throw new IllegalArgumentException("Phone number needs to" +
          " be a string of length 10");
    }
    boolean allDigit = true;
    for (int i = 0; i < phoneNumber.length(); i++) {
      if (!Character.isDigit(phoneNumber.charAt(i))) {
        allDigit = false;
        break;
      }
    }
    if (allDigit) {
      this.phoneNumber = phoneNumber;
    } else {
      throw new IllegalArgumentException("Phone number needs to be a 10-digit " +
          "string, and it cannot contain other characters except for integers");
    }
  }
}
