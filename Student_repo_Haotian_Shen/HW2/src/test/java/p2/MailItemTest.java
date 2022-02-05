package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MailItemTest {

  MailItem mailItem;

  @Before
  public void setUp() {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    mailItem = new MailItem(10, 10, 10, recipient);
  }

  @Test
  public void getWidth() {
    Integer testWidth = 10;
    assertEquals(testWidth, mailItem.getWidth());
  }

  @Test
  public void setWidth() {
    mailItem.setWidth(15);
    assertEquals(15, mailItem.getWidth(), 0);
  }

  @Test
  public void getHeight() {
    assertEquals(10, mailItem.getHeight(), 0);
  }

  @Test
  public void setHeight() {
    mailItem.setHeight(15);
    assertEquals(15, mailItem.getHeight(), 0);
  }

  @Test
  public void getDepth() {
    assertEquals(10, mailItem.getDepth(), 0);
  }

  @Test
  public void setDepth() {
    mailItem.setDepth(15);
    assertEquals(15, mailItem.getDepth(), 0);
  }

  @Test
  public void getRecipient() {
    Recipient expectedRecipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    assertEquals(expectedRecipient, mailItem.getRecipient());
  }

  @Test
  public void setRecipient() {
    Recipient expectedRecipient = new Recipient("Shen", "Haotian", "cba@gmail.com");
    mailItem.setRecipient(expectedRecipient);
    assertEquals(expectedRecipient, mailItem.getRecipient());
  }

  @Test
  public void testEqualsWithSameMemoryAddress() {
    MailItem mailItemSameAddress = mailItem;
    assertTrue(mailItem.equals(mailItemSameAddress) && mailItemSameAddress.equals(mailItem));
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContents() {
    MailItem mailItemSameContents = new MailItem(mailItem);
    assertTrue(mailItem.equals(mailItemSameContents) && mailItemSameContents.equals(mailItem)
        && mailItemSameContents.hashCode() == mailItem.hashCode());
  }

  @Test
  public void testEqualsDifferentClass() {
    Recipient recipient = new Recipient("Shen", "Haotian", "cba@gmail.com");
    assertFalse(recipient.equals(mailItem) || mailItem.equals(recipient));
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContents() {
    Recipient recipientOne = new Recipient("Haotian", "Haotian", "abc@gmail.com");
    MailItem mailItemOne = new MailItem(10, 10, 10, recipientOne);
    Recipient recipientTwo = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItemTwo = new MailItem(12, 12, 12, recipientTwo);
    assertFalse(recipientOne.equals(recipientTwo) || recipientTwo.equals(recipientOne));
  }
}