package problem1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * NonProfit class represents a non-profit organization with a name and a collections of donations.
 */
public class NonProfit {

  private final String name;
  private final Map<Integer, Map<LocalDateTime, Donation>> donations;

  /**
   * Constructor that creates a NonProfit object with the given name.
   *
   * @param name - String, the name.
   */
  public NonProfit(String name) {
    this.name = name;
    this.donations = new HashMap<>();
  }

  /**
   * Getter for non-profit org name.
   *
   * @return - String, the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the donation collection of this non-profit org.
   *
   * @return - Map<Integer, Map<LocalDateTime, Donation>>, the collection.
   */
  public Map<Integer, Map<LocalDateTime, Donation>> getDonations() {
    return donations;
  }

  /**
   * Get the total donations for the given year for this non-profit org.
   *
   * @param year - Integer, the given year.
   * @return - Double, total donations for the given year.
   */
  public Double getTotalDonationsForYear(Integer year) {
    Map<LocalDateTime, Donation> donationsForYear = donations.get(year);
    int size = donationsForYear.size();
    Double sum = 0.0;
    for (LocalDateTime identifier : donationsForYear.keySet()) {
      Donation d = donationsForYear.get(identifier);
      sum += d.getDonationAmountForYear(year);
    }
    return sum;
  }

  /**
   * Compare whether two NonProfit objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonProfit)) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return getName().equals(nonProfit.getName()) && getDonations().equals(nonProfit.getDonations());
  }

  /**
   * Generate hashcode for the NonProfit object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  /**
   * String expression for the NonProfit object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "name='" + name + '\'' +
        ", donations=" + donations +
        '}';
  }
}
