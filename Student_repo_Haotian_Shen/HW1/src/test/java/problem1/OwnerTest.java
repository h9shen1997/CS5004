package problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OwnerTest {

  private Owner owner;

  @Before
  public void setUp() throws NullPointerException {
    owner = new Owner("Haotian", "Shen", "6787994644");
    if (owner == null) {
      throw new NullPointerException("The Owner object has not been initialized yet");
    }
  }

  @Test
  public void getFirstName() {
    String expectedFirstName = "Haotian";
    assertEquals("The first name must be Haotian", expectedFirstName,
        owner.getFirstName());
  }

  @Test
  public void setFirstName() {
    String expectedFirstName = "Shen";
    owner.setFirstName(expectedFirstName);
    assertEquals("The first name should be changed to Shen", expectedFirstName,
        owner.getFirstName());
  }

  @Test
  public void getLastName() {
    String expectedLastName = "Shen";
    assertEquals("The last name must be Shen", expectedLastName, owner.getLastName());
  }

  @Test
  public void setLastName() {
    String expectedLastName = "Haotian";
    owner.setLastName(expectedLastName);
    assertEquals("The last name should be changed to Haotian", expectedLastName,
        owner.getLastName());
  }

  @Test
  public void getPhoneNumber() {
    String expectedPhoneNumber = "6787994644";
    assertEquals("The phone number must be 6787994644", expectedPhoneNumber,
        owner.getPhoneNumber());
  }

  @Test
  public void setPhoneNumber() throws IllegalArgumentException {
    String expectedPhoneNumber = "6787994645";
    owner.setPhoneNumber(expectedPhoneNumber);
    assertEquals("The phone number should be changed to 6787994645",
        expectedPhoneNumber, owner.getPhoneNumber());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPhoneNumberTooShort() throws IllegalArgumentException {
    String phoneNumberTooShort = "6789";
    owner.setPhoneNumber(phoneNumberTooShort);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPhoneNumberTooLong() throws IllegalArgumentException {
    String phoneNumberTooLong = "678799464432";
    owner.setPhoneNumber(phoneNumberTooLong);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPhoneNumberOtherThanDigit() throws IllegalArgumentException {
    String phoneNumberContainsCharacter = "678799dgdh";
    owner.setPhoneNumber(phoneNumberContainsCharacter);
  }


}