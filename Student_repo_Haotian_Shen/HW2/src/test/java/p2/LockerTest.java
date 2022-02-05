package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {

  Locker locker;

  @Before
  public void setUp() throws IllegalDimensionException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
  }

  @Test(expected = IllegalDimensionException.class)
  public void generateLockerWithBiggerMailItem() throws IllegalDimensionException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(15, 11, 5, recipient);
    Locker locker = new Locker(10, 10, 10, mailItem);
  }

  @Test
  public void getMaxWidth() {
    assertEquals(10, locker.getMaxWidth(), 0);
  }

  @Test
  public void setMaxWidth() {
    locker.setMaxWidth(15);
    assertEquals(15, locker.getMaxWidth(), 0);
  }

  @Test
  public void getMaxHeight() {
    assertEquals(10, locker.getMaxHeight(), 0);
  }

  @Test
  public void setMaxHeight() {
    locker.setMaxHeight(15);
    assertEquals(15, locker.getMaxHeight(), 0);
  }

  @Test
  public void getMaxDepth() {
    assertEquals(10, locker.getMaxDepth(), 0);
  }

  @Test
  public void setMaxDepth() {
    locker.setMaxDepth(15);
    assertEquals(15, locker.getMaxDepth(), 0);
  }

  @Test
  public void getMailItem() {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    assertEquals(mailItem, locker.getMailItem());
  }

  @Test
  public void setMailItemLegalDimension() throws IllegalDimensionException {
    locker.setMaxDepth(15);
    locker.setMaxHeight(15);
    locker.setMaxWidth(15);
    Recipient recipient = new Recipient("Shen", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(10, 10, 10, recipient);
    locker.setMailItem(mailItem);
    assertEquals(mailItem, locker.getMailItem());
  }

  @Test(expected = IllegalDimensionException.class)
  public void setMailItemIllegalDimension() throws IllegalDimensionException {
    locker.setMaxDepth(15);
    locker.setMaxHeight(15);
    locker.setMaxWidth(15);
    Recipient recipient = new Recipient("Shen", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(20, 20, 20, recipient);
    locker.setMailItem(mailItem);
  }

  @Test
  public void addMailLegalDimensionEmpty()
      throws IllegalDimensionException, LockerOccupiedException {
    locker.setMaxDepth(15);
    locker.setMaxHeight(15);
    locker.setMaxWidth(15);
    locker.setMailItem(null);
    Recipient recipient = new Recipient("Shen", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(10, 10, 10, recipient);
    locker.addMail(mailItem);
    assertEquals(mailItem, locker.getMailItem());
  }

  @Test(expected = LockerOccupiedException.class)
  public void addMailLegalDimensionNotEmpty()
      throws IllegalDimensionException, LockerOccupiedException {
    locker.setMaxDepth(15);
    locker.setMaxHeight(15);
    locker.setMaxWidth(15);
    locker.setMailItem(null);
    Recipient recipient = new Recipient("Shen", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(10, 10, 10, recipient);
    locker.addMail(mailItem);
    MailItem mailItemCopy = new MailItem(10, 10, 10, recipient);
    locker.addMail(mailItemCopy);
  }

  @Test(expected = IllegalDimensionException.class)
  public void addMailIllegalDimensionEmpty()
      throws IllegalDimensionException, LockerOccupiedException {
    locker.setMaxDepth(15);
    locker.setMaxHeight(15);
    locker.setMaxWidth(15);
    locker.setMailItem(null);
    Recipient recipient = new Recipient("Shen", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(25, 25, 25, recipient);
    locker.addMail(mailItem);
  }

  @Test(expected = EmptyLockerException.class)
  public void pickupMailEmptyLocker()
      throws IllegalDimensionException, EmptyLockerException, IllegalRecipientException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
    locker.setMailItem(null);
    MailItem mailItemCopy = locker.pickupMail(recipient);
  }

  @Test
  public void pickupMailRecipientSameContentsDifferentMemoryAddress()
      throws EmptyLockerException, IllegalDimensionException, IllegalRecipientException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
    Recipient recipientCopy = new Recipient(recipient);
    MailItem mailItemSame = locker.pickupMail(recipientCopy);
    assertEquals(mailItem.getRecipient(), mailItemSame.getRecipient());
  }

  @Test
  public void pickupMailSameRecipient()
      throws EmptyLockerException, IllegalDimensionException, IllegalRecipientException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
    MailItem mailItemSame = locker.pickupMail(recipient);
    assertEquals(mailItemSame.getRecipient(), mailItem.getRecipient());
  }

  @Test(expected = IllegalRecipientException.class)
  public void pickupMailWrongRecipient()
      throws EmptyLockerException, IllegalDimensionException, IllegalRecipientException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
    Recipient wrongRecipient = new Recipient("Shen", "Haotian", "abcd@gmail.com");
    locker.pickupMail(wrongRecipient);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws IllegalDimensionException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
    Locker lockerCopy = locker;
    assertTrue(locker.equals(lockerCopy) && lockerCopy.equals(locker)
        && locker.hashCode() == lockerCopy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContents() throws IllegalDimensionException {
    Recipient recipientOne = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItemOne = new MailItem(5, 5, 5, recipientOne);
    Locker lockerOne = new Locker(10, 10, 10, mailItemOne);
    Recipient recipientTwo = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItemTwo = new MailItem(5, 5, 5, recipientTwo);
    Locker lockerTwo = new Locker(10, 10, 10, mailItemTwo);
    assertTrue(lockerOne.equals(lockerTwo) && lockerTwo.equals(lockerOne)
        && lockerOne.hashCode() == lockerTwo.hashCode());
  }

  @Test
  public void testEqualsDifferentClass() throws IllegalDimensionException {
    Recipient recipient = new Recipient("Haotian", "Shen", "abc@gmail.com");
    MailItem mailItem = new MailItem(5, 5, 5, recipient);
    locker = new Locker(10, 10, 10, mailItem);
    assertFalse(locker.equals(mailItem) || mailItem.equals(locker));
  }
}