package problem1;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * MonthlyDonation class represents a monthly donation created by the donor until cancelled.
 */
public class MonthlyDonation extends Donation {

  private static final int MONTH_MAX = 12;
  private LocalDateTime cancelDateTime;

  /**
   * Constructor to create a MonthlyDonation object with the specified non-profit organization, the
   * amount of donation, and the creation date and time. The cancel date and time is not specified
   * at the time of creation.
   *
   * @param np             - NonProfit, the non-profit org.
   * @param amount         - Double, the amount of monthly donation.
   * @param createDateTime - LocalDateTime, the creation date and time.
   */
  public MonthlyDonation(NonProfit np, Double amount, LocalDateTime createDateTime) {
    super(np, amount, createDateTime);
    Integer year = createDateTime.getYear();
    addDonation(year);
  }

  /**
   * Getter for cancel date and time.
   *
   * @return - LocalDateTime, the cancel date and time.
   */
  public LocalDateTime getCancelDateTime() {
    return cancelDateTime;
  }

  /**
   * Setter for cancel date and time. If the MonthlyDonation object currently does not have a cancel
   * date and time, simply set it. Otherwise, only set it to the new cancel date and time if the new
   * date is after the creation date. It can also remove the current cancel date and time by setting
   * the current one to null.
   *
   * @param cancelDateTime - LocalDateTime, the new cancel date and time.
   * @throws IllegalArgumentException if the proposed cancel date and time is not after the create
   *                                  date and time.
   */
  public void setCancelDateTime(LocalDateTime cancelDateTime) throws IllegalArgumentException {
    Map<Integer, Map<LocalDateTime, Donation>> donations = this.np.getDonations();
    Map<LocalDateTime, Donation> identifierToDonation = donations.get(
        getCreateDateTime().getYear());
    Donation d = identifierToDonation.get(getCreateDateTime());
    if (cancelDateTime == null) {
      ((MonthlyDonation) d).cancelDateTime = null;
    } else {
      if (!cancelDateTime.isBefore(d.getCreateDateTime())) {
        ((MonthlyDonation) d).cancelDateTime = cancelDateTime;
      } else {
        throw new IllegalArgumentException(
            "The cancel date and time cannot be prior to the creation date and time");
      }
    }
  }

  /**
   * Get the total monthly donation amount for the given year. If the cancel date and time is not
   * set or after the given year, then add all the donation after create date of this year. If the
   * cancel date is within the same year and after the creation date and time, only add the donation
   * within the duration from create to cancel date and time.
   *
   * @param year - Integer, the specified year.
   * @return - Double, the total monthly donation for the given year.
   */
  @Override
  public Double getDonationAmountForYear(Integer year) {
    LocalDateTime cancelDateTime = getCancelDateTime();
    int createMonth = getCreateDateTime().getMonthValue();
    int cancelMonth = (cancelDateTime == null || getCancelDateTime().getYear() > year) ? MONTH_MAX
        : getCancelDateTime().getMonthValue();
    int duration = cancelMonth - createMonth + 1;
    return duration * getAmount();
  }

  /**
   * Compare whether two MonthlyDonation objects are equal.
   *
   * @param o - Object, the other object.
   * @return = boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MonthlyDonation)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(getCancelDateTime(), that.getCancelDateTime());
  }

  /**
   * Generate hashcode for the MonthlyDonation object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCancelDateTime());
  }

  /**
   * String expression for the MonthlyDonation object.
   *
   * @return - String, string expression.
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "cancelDateTime=" + cancelDateTime == null ? "" : cancelDateTime.toString() +
        "} " + super.toString();
  }
}
