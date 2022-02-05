package problem1;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * Pledge class represents a promise to donate a given amount at some point in the future.
 */
public class Pledge extends Donation {

  private LocalDateTime processedDateTime;

  /**
   * Constructor to create a Pledge object with the specified non-profit organization, the amount,
   * and the creation date and time, without a processed date and time.
   *
   * @param np             - NonProfit, the non-profit org.
   * @param amount         - Double, the amount of pledge donation.
   * @param createDateTime - LocalDateTime, the creation date and time.
   */
  public Pledge(NonProfit np, Double amount, LocalDateTime createDateTime) {
    super(np, amount, createDateTime);
    Integer year = createDateTime.getYear();
    addDonation(year);
  }

  /**
   * Constructor to create a Pledge object with the specified non-profit organization, the amount,
   * the create date and time, and a processed date and time.
   *
   * @param np                - NonProfit, the non-profit org.
   * @param amount            - Double, the amount of pledge donation.
   * @param createDateTime    - LocalDateTime, the creation date and time.
   * @param processedDateTime - LocalDateTime, the processed date and time.
   * @throws IllegalArgumentException if the processed date and time is prior to the creation date
   *                                  and time.
   */
  public Pledge(NonProfit np, Double amount, LocalDateTime createDateTime,
      LocalDateTime processedDateTime) throws IllegalArgumentException {
    this(np, amount, createDateTime);
    if (processedDateTime.isBefore(createDateTime)) {
      throw new IllegalArgumentException(
          "The processed date and time cannot be prior to the creation date and time.");
    }
    this.processedDateTime = processedDateTime;
  }

  /**
   * Getter for the processed date and time.
   *
   * @return - LocalDateTime, processed date and time.
   */
  public LocalDateTime getProcessedDateTime() {
    return processedDateTime;
  }

  /**
   * Setter for processed date and time. Can remove the processed date and time if the given
   * processed date and time is null. Otherwise, only change the processed date and time if there is
   * no processed date and time or the given processed date and time is prior to the creation date
   * and time.
   *
   * @param processedDateTime - LocalDateTime, the new processed date and time.
   */
  public void setProcessedDateTime(LocalDateTime processedDateTime) {
    Map<Integer, Map<LocalDateTime, Donation>> donations = this.np.getDonations();
    Map<LocalDateTime, Donation> identifierToDonation = donations.get(
        getCreateDateTime().getYear());
    Donation d = identifierToDonation.get(getCreateDateTime());
    if (processedDateTime == null) {
      ((Pledge) d).processedDateTime = null;
    } else {
      if (((Pledge) d).getProcessedDateTime() == null || !processedDateTime.isBefore(
          d.getCreateDateTime())) {
        ((Pledge) d).processedDateTime = processedDateTime;
      } else {
        throw new IllegalArgumentException(
            "The new processed date and time cannot be prior to the current one");
      }
    }
  }

  /**
   * Get the pledge amount if the processed date and time is set and the year is the same as the
   * given year.
   *
   * @param year - Integer, the specified year.
   * @return - Double, the pledge amount for the given year.
   */
  @Override
  public Double getDonationAmountForYear(Integer year) {
    LocalDateTime processedDateTime = getProcessedDateTime();
    if (processedDateTime == null) {
      return 0.0;
    }
    int processedYear = processedDateTime.getYear();
    return processedYear == year ? getAmount() : 0.0;
  }

  /**
   * Compare whether two Pledge objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pledge)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Pledge pledge = (Pledge) o;
    return Objects.equals(getProcessedDateTime(), pledge.getProcessedDateTime());
  }

  /**
   * Generate hashcode for the Pledge object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getProcessedDateTime());
  }

  /**
   * String expression for the Pledge object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Pledge{" +
        "processedDateTime=" + processedDateTime.toString() +
        "} " + super.toString();
  }
}
