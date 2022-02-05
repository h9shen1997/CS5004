package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {

  Recipient recipient;

  @Before
  public void setUp() throws IllegalArgumentException {
    recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorWithInvalidEmail() {
    Recipient invalidRecipient = new Recipient("Haotian", "Shen", "@gmail.com");
  }

  @Test
  public void getFirstName() {
    assertEquals("Haotian", recipient.getFirstName());
  }

  @Test
  public void setFirstName() {
    recipient.setFirstName("Shen");
    assertEquals("Shen", recipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Shen", recipient.getLastName());
  }

  @Test
  public void setLastName() {
    recipient.setLastName("Haotian");
    assertEquals("Haotian", recipient.getLastName());
  }

  @Test
  public void getEmailAddress() {
    assertEquals("abc@gmail.com", recipient.getEmailAddress());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setEmailAddressInvalidEmail() {
    recipient.setEmailAddress("@yahoo.com");
  }

  @Test
  public void setEmailAddressValidEmail() {
    recipient.setEmailAddress("abcd@yahoo.com");
    assertEquals("abcd@yahoo.com", recipient.getEmailAddress());
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Recipient recipientSameMemoryAddress = recipient;
    assertTrue(recipientSameMemoryAddress.equals(recipient) && recipient.equals(
        recipientSameMemoryAddress));
  }

  @Test
  public void testEqualsDifferentAddressSameContents() {
    Recipient recipientSameContents = new Recipient(recipient);
    assertTrue(recipientSameContents.equals(recipient) && recipient.equals(recipientSameContents)
        && recipientSameContents.hashCode() == recipient.hashCode());
  }

  @Test
  public void testEqualsDifferentClass() {
    MailItem mailItem = new MailItem(10, 10, 10, recipient);
    assertFalse(mailItem.equals(recipient) || recipient.equals(mailItem));
  }

  @Test
  public void testEqualsDifferentAddressDifferentContents() {
    Recipient recipientDifferentContentsOne = new Recipient("Haotian", "Shen", "abc@gmail.com");
    Recipient recipientDifferentContentsTwo = new Recipient("Shen", "Shen", "abcd@gmail.com");
    assertFalse(recipientDifferentContentsOne.equals(recipientDifferentContentsTwo)
        || recipientDifferentContentsTwo.equals(recipientDifferentContentsOne));
  }
}