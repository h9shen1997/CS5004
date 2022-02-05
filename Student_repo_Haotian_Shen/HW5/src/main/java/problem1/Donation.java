package problem1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Donation class stores general information of a donation, the amount, the create date and time,
 * and the non-profit organization this donation is intended for. It can be inherited to account for
 * all kinds of donation in the future.
 */
public abstract class Donation {

  protected Double amount;
  protected LocalDateTime createDateTime;
  protected NonProfit np;

  /**
   * Constructor for Donation with the specified non-profit organization, the amount, and the
   * creation date and time.
   *
   * @param np             - NonProfit, the non-profit organization.
   * @param amount         - Double, the amount of donation.
   * @param createDateTime - LocalDateTime, the creation date and time.
   */
  public Donation(NonProfit np, Double amount, LocalDateTime createDateTime) {
    this.np = np;
    this.amount = amount;
    this.createDateTime = createDateTime;
  }

  /**
   * Getter for amount of donation.
   *
   * @return - Double, the amount.
   */
  protected Double getAmount() {
    return amount;
  }

  /**
   * Getter for create date and time.
   *
   * @return - LocalDateTime, the creation date and time.
   */
  protected LocalDateTime getCreateDateTime() {
    return createDateTime;
  }

  /**
   * Getter for the non-profit organization.
   *
   * @return - NonProfit, the non-profit org.
   */
  protected NonProfit getNp() {
    return np;
  }

  /**
   * Add the donation to the specified year in the non-profit organization.
   *
   * @param year - Integer, the specified year.
   */
  protected void addDonation(Integer year) {
    Map<Integer, Map<LocalDateTime, Donation>> donations = this.np.getDonations();
    if (!donations.containsKey(year)) {
      donations.put(year, new HashMap<>());
    }
    Map<LocalDateTime, Donation> identifierToDonation = donations.get(year);
    identifierToDonation.put(this.createDateTime, this);
  }

  /**
   * Get the donation amount for the specified year.
   *
   * @param year - Integer, the specified year.
   * @return - Double, the amount of total donation in the specified year.
   */
  protected abstract Double getDonationAmountForYear(Integer year);

  /**
   * Compare whether two Donation objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Donation)) {
      return false;
    }
    Donation donation = (Donation) o;
    return getAmount().equals(donation.getAmount()) && getCreateDateTime().equals(
        donation.getCreateDateTime()) && getNp().equals(donation.getNp());
  }

  /**
   * Generate hashcode for the Donation object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAmount(), getCreateDateTime(), getNp());
  }

  /**
   * String expression of the Donation object.
   *
   * @return - String, string expression.
   */
  @Override
  public String toString() {
    return "Donation{" +
        "amount=" + amount +
        ", createDateTime=" + createDateTime +
        ", np=" + np +
        '}';
  }
}
