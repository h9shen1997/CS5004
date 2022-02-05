package problem1;

import java.time.LocalDateTime;

/**
 * SingleDonation class represents a single donation to the non-profit organization.
 */
public class SingleDonation extends Donation {

  /**
   * Constructor that creates a SingleDonation object with the specified non-profit organization,
   * the amount of donation, and the create date and time. After creation, this SingleDonation will
   * be added to specified year in the non-profit organization's donation records.
   *
   * @param np             - NonProfit, the non-profit org.
   * @param amount         - Double, the amount of donation.
   * @param createDateTime - LocalDateTime, the creation date and time.
   */
  public SingleDonation(NonProfit np, Double amount, LocalDateTime createDateTime) {
    super(np, amount, createDateTime);
    Integer year = createDateTime.getYear();
    addDonation(year);
  }

  /**
   * Get the donation amount for this single donation in the given year.
   *
   * @param year - Integer, the specified year.
   * @return - Double, the donation amount;
   */
  @Override
  public Double getDonationAmountForYear(Integer year) {
    return getAmount();
  }

  /**
   * String expression for the SingleDonation object.
   *
   * @return - String, string expression.
   */
  @Override
  public String toString() {
    return "SingleDonation{} " + super.toString();
  }

  /**
   * Compare whether two SingleDonation objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SingleDonation)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode for the SingleDonation object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
