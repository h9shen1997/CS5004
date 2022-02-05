package p2;

import java.util.Objects;

/**
 * MailItem stores information of the size of the mail item and its recipient.
 */
public class MailItem {

  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;

  /**
   * Constructor that creates a mail item object with the specified size and recipient.
   *
   * @param width     - Integer, width.
   * @param height    - Integer height.
   * @param depth     - Integer, depth.
   * @param recipient - Recipient, the designated recipient.
   */
  public MailItem(Integer width, Integer height, Integer depth, Recipient recipient) {
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = new Recipient(recipient);
  }

  /**
   * Copy constructor to create a new mail item fromt the existing one.
   *
   * @param mailItem - MailItem, the passed-in mail item.
   */
  public MailItem(MailItem mailItem) {
    this.width = mailItem.getWidth();
    this.height = mailItem.getHeight();
    this.depth = mailItem.getDepth();
    this.recipient = new Recipient(mailItem.getRecipient());
  }

  /**
   * Getter for width.
   *
   * @return - Integer, the width.
   */
  public Integer getWidth() {
    return this.width;
  }

  /**
   * Setter for width.
   *
   * @param width - Integer, the width.
   */
  public void setWidth(Integer width) {
    this.width = width;
  }

  /**
   * Getter for height.
   *
   * @return - Integer, the height.
   */
  public Integer getHeight() {
    return this.height;
  }

  /**
   * Setter for height.
   *
   * @param height - Integer, the height.
   */
  public void setHeight(Integer height) {
    this.height = height;
  }

  /**
   * Getter for depth.
   *
   * @return - Integer, the depth.
   */
  public Integer getDepth() {
    return this.depth;
  }

  /**
   * Setter for height.
   *
   * @param depth - Integer, the depth.
   */
  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  /**
   * Getter for the recipient.
   *
   * @return - Recipient, the recipient of the mail item.
   */
  public Recipient getRecipient() {
    return recipient;
  }

  /**
   * Setter for the recipient.
   *
   * @param recipient - Recipient, the recipient of the mail item.
   */
  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }

  /**
   * Compare whether two mail item objects are equal.
   *
   * @param o - Object, the mail item to be compared.
   * @return - Boolean, whether the two mail items are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MailItem)) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return getWidth().equals(mailItem.getWidth()) && getHeight().equals(mailItem.getHeight())
        && getDepth().equals(mailItem.getDepth()) && getRecipient().equals(mailItem.getRecipient());
  }


  /**
   * Generate the hashcode for the mail item object.
   *
   * @return - int, the hashcode for the mail item object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWidth(), getHeight(), getDepth(), getRecipient());
  }
}
