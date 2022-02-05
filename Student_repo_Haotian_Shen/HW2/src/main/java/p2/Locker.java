package p2;

import java.util.Objects;

/**
 * Locker is an object that stores the dimension of a locker and the mail item inside it.
 */
public class Locker {

  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem mailItem;

  /**
   * Constructor that creates a locker object with the specified dimensions and mail item.
   *
   * @param maxWidth  - Integer, width.
   * @param maxHeight - Integer, height.
   * @param maxDepth  - Integer, depth.
   * @param mailItem  - Mailitem, the mail item inside the locker.
   * @throws IllegalDimensionException if the mail item size is larger than the dimensions of the
   *                                   locker.
   */
  public Locker(Integer maxWidth, Integer maxHeight, Integer maxDepth, MailItem mailItem)
      throws IllegalDimensionException {
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    if (dimensionBigger(mailItem)) {
      throw new IllegalDimensionException(
          "The mailItem used to generate this locker is too big to fit");
    } else {
      this.mailItem = mailItem;
    }
  }

  /**
   * Getter for max width.
   *
   * @return - Integer, max width.
   */
  public Integer getMaxWidth() {
    return this.maxWidth;
  }

  /**
   * Setter for max width.
   *
   * @param maxWidth - Integer, max width.
   */
  public void setMaxWidth(Integer maxWidth) {
    this.maxWidth = maxWidth;
  }

  /**
   * Getter for max height.
   *
   * @return - Integer, max height.
   */
  public Integer getMaxHeight() {
    return this.maxHeight;
  }

  /**
   * Setter for max height.
   *
   * @param maxHeight - Integer, max height.
   */
  public void setMaxHeight(Integer maxHeight) {
    this.maxHeight = maxHeight;
  }

  /**
   * Getter for max depth.
   *
   * @return - Integer, max depth.
   */
  public Integer getMaxDepth() {
    return this.maxDepth;
  }

  /**
   * Setter for max depth.
   *
   * @param maxDepth - Integer, max depth.
   */
  public void setMaxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
  }

  /**
   * Getter for mail item inside the locker.
   *
   * @return - MailItem, the mail item inside the locker.
   */
  public MailItem getMailItem() {
    return this.mailItem;
  }

  /**
   * Setter for mail item inside the locker.
   *
   * @param mailItem - MailItem, the mail item inside the locker.
   * @throws IllegalDimensionException if the size of the mail item is larger than the dimension of
   *                                   the locker.
   */
  public void setMailItem(MailItem mailItem) throws IllegalDimensionException {
    if (mailItem == null) {
      this.mailItem = null;
      return;
    }
    if (dimensionBigger(mailItem)) {
      throw new IllegalDimensionException(
          "The mailItem's dimension is bigger than the dimension of the locker");
    } else {
      this.mailItem = mailItem;
    }
  }

  /**
   * Add the mail into the locker.
   *
   * @param mailItem - MailItem, the mail item to be added into the locker.
   * @throws LockerOccupiedException   if locker is already occupied.
   * @throws IllegalDimensionException if the size of the mail item is larger than the dimension of
   *                                   the locker.
   */
  public void addMail(MailItem mailItem) throws LockerOccupiedException, IllegalDimensionException {
    if (!isLockerEmpty()) {
      throw new LockerOccupiedException("The locker has already been occupied");
    }
    if (dimensionBigger(mailItem)) {
      throw new IllegalDimensionException("The item is bigger than locker's capacity");
    }
    this.mailItem = mailItem;
  }

  /**
   * Helper method to check if the locker is empty.
   *
   * @return - Boolean, whether the locker is empty.
   */
  private boolean isLockerEmpty() {
    return mailItem == null;
  }

  /**
   * Helper method to check if the mail item has bigger size than the dimension of the locker.
   *
   * @param mailItem - MailItem, the mail item to be added.
   * @return - Boolean, whether the mail item can fit.
   */
  private boolean dimensionBigger(MailItem mailItem) {
    return mailItem.getWidth() > this.maxWidth || mailItem.getDepth() > this.maxDepth
        || mailItem.getHeight() > this.maxHeight;
  }

  /**
   * Helper method to check if the recipient is the same as the designated one.
   *
   * @param recipient - Recipient, the compared recipient.
   * @return - Boolean, whether the correct recipient.
   */
  private boolean isSameRecipient(Recipient recipient) {
    return recipient.equals(getMailItem().getRecipient());
  }

  /**
   * Pick up the mail by the recipient and clear the locker afterward.
   *
   * @param recipient - Recipient, the pick up recipient.
   * @return - MailItem, the mail item retrived from the locker.
   * @throws EmptyLockerException      if the locker is empty already.
   * @throws IllegalRecipientException if the recipient is not the desingated recipient for the mail
   *                                   item.
   */
  public MailItem pickupMail(Recipient recipient)
      throws EmptyLockerException, IllegalRecipientException, IllegalDimensionException {
    if (isLockerEmpty()) {
      throw new EmptyLockerException("The locker is currently empty");
    }
    if (!isSameRecipient(recipient)) {
      throw new IllegalRecipientException(
          "The recipient is not the same as the recipient intended for the mail item");
    }
    MailItem mailItemCopy = new MailItem(this.mailItem);
    setMailItem(null);
    return mailItemCopy;
  }

  /**
   * Compare two locker object.
   *
   * @param o - Object, the locker to be compared.
   * @return - Boolean, whether the two lockers are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Locker)) {
      return false;
    }
    Locker locker = (Locker) o;
    return getMaxWidth().equals(locker.getMaxWidth()) && getMaxHeight().equals(
        locker.getMaxHeight())
        && getMaxDepth().equals(locker.getMaxDepth()) && getMailItem().equals(locker.getMailItem());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMaxWidth(), getMaxHeight(), getMaxDepth(), getMailItem());
  }
/**
 * Generate the hashcode for the locker object.
 *
 * @return - int, the hashcode for the locker object.
 */

}
