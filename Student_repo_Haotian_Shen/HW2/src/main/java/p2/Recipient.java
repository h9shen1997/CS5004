package p2;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Recipient stores information of the name and email address of the recipient.
 */
public class Recipient {

  // regex used to check email validity.
  private static final String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * Constructor that creates a recipient with the specified name and email.
   *
   * @param firstName    - String, first name.
   * @param lastName     - String, last name.
   * @param emailAddress - String, email address.
   * @throws IllegalArgumentException if the email address is not valid.
   */
  public Recipient(String firstName, String lastName, String emailAddress)
      throws IllegalArgumentException {
    if (!isEmailValid(emailAddress)) {
      throw new IllegalArgumentException("The email address provided does not have valid format");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Copy constructor that creates a recipient object from the exisiting one.
   *
   * @param recipient - Recipient, the recipient to be copied from.
   */
  public Recipient(Recipient recipient) {
    this.firstName = recipient.getFirstName();
    this.lastName = recipient.getLastName();
    this.emailAddress = recipient.getEmailAddress();
  }

  /**
   * Getter for first name.
   *
   * @return - String, first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Setter for first name.
   *
   * @param firstName - String, first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Getter for last name.
   *
   * @return - String, last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Setter for last name.
   *
   * @param lastName - String, last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Getter for email address.
   *
   * @return - String, email address.
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  /**
   * Setter for email address.
   *
   * @param emailAddress - String, email address.
   * @throws IllegalArgumentException if the email address is not valid.
   */
  public void setEmailAddress(String emailAddress) throws IllegalArgumentException {
    if (!isEmailValid(emailAddress)) {
      throw new IllegalArgumentException("The email address provided does not have valid format");
    }
    this.emailAddress = emailAddress;
  }

  /**
   * Check whether the email is valid using regular expression.
   *
   * @param emailAddress - specified email address.
   * @return - Boolean, whether the email is valid or not.
   */
  private boolean isEmailValid(String emailAddress) {
    Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(emailAddress);
    return matcher.matches();
  }

  /**
   * Compare whether two recipient objects are equal.
   *
   * @param o - Object, the objects to be compared.
   * @return - Boolean, whether the two recipient objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Recipient)) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return getFirstName().equals(recipient.getFirstName()) && getLastName().equals(
        recipient.getLastName()) && getEmailAddress().equals(recipient.getEmailAddress());
  }


  /**
   * Generate the hashcode for the recipient object.
   *
   * @return - int, hashcode for the recipient object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getEmailAddress());
  }

}
