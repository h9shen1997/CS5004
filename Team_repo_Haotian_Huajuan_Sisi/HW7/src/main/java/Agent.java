import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Agent is a generic class that can either specialize in a specific listing or take whatever type
 * of listings available.
 *
 * @param <T> - the generic listing agent can do.
 */
public class Agent<T extends Listing> {

  private final String name;
  private final Set<T> listings = new HashSet<>();
  private final Double commissionRate;
  private Double totalEarnings = 0.0;

  /**
   * Constructor for agent with the specified name and commission rate.
   *
   * @param name           - agent's name.
   * @param commissionRate - commission rate.
   * @throws CommissionRateException if the commission rate is not between 0 and 1, inclusive.
   */
  public Agent(String name, Double commissionRate) throws CommissionRateException {
    this.name = name;
    if (commissionRate < 0 || commissionRate > 1) {
      throw new CommissionRateException("commission rate must be between 0 and 1(inclusive)");
    }
    this.commissionRate = commissionRate;
  }

  /**
   * add listing to the collection if the listing is not in the collection.
   *
   * @param listing - the added listing.
   */
  public void addListing(T listing) {
    this.listings.add(listing);
  }

  /**
   * Complete the listing and add the listing's commissions to the agent's total earnings.
   *
   * @param listing - the completed listing.
   * @throws ListingNotFoundException if the listing is not found in the agent's listing
   *                                  collection.
   */
  public void completeListing(T listing) throws ListingNotFoundException {
    this.dropListing(listing);
    this.totalEarnings += this.calculateValueOfListing(listing);
  }

  /**
   * Drop the listing from collection if it's in the collection or throw exception.
   *
   * @param listing pair property and contract.
   * @throws ListingNotFoundException if listing is not in the Listing collection.
   */
  public void dropListing(T listing) throws ListingNotFoundException {
    if (this.listings.contains(listing)) {
      this.listings.remove(listing);
    } else {
      throw new ListingNotFoundException("listing not found");
    }
  }

  /**
   * Calculate the agent's commission if completed the listing.
   *
   * @param listing pair property and contract.
   * @return value of listing as double.
   */
  private double calculateValueOfListing(T listing) {
    return listing.getContract().getValue() * this.commissionRate;
  }

  /**
   * Calculate the amount of money the agent would make if they completed all listings in their
   * collection plus the previous earning of the agent.
   *
   * @return total expected money as double.
   */
  public double getTotalPortfolioValue() {
    double total = this.totalEarnings;
    for (T curListing : this.listings) {
      total += this.calculateValueOfListing(curListing);
    }
    return total;
  }

  /**
   * Get the name of agent.
   *
   * @return the name as string.
   */
  public String getName() {
    return name;
  }

  /**
   * Get the collection of listing.
   *
   * @return collection as listings.
   */
  public Set<T> getListings() {
    return listings;
  }

  /**
   * Get the agent's commission rate.
   *
   * @return commission rate as double.
   */
  public Double getCommissionRate() {
    return commissionRate;
  }

  /**
   * Get the agent's total earning.
   *
   * @return total earning as double.
   */
  public Double getTotalEarnings() {
    return totalEarnings;
  }

  /**
   * Compare two object whether they are the same.
   *
   * @param o the object to be compared with.
   * @return true if two object is the same else return false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Agent)) {
      return false;
    }
    Agent<?> agent = (Agent<?>) o;
    return Objects.equals(getName(), agent.getName()) && Objects.equals(
        getListings(), agent.getListings()) && Objects.equals(getCommissionRate(),
        agent.getCommissionRate()) && Objects.equals(getTotalEarnings(),
        agent.getTotalEarnings());
  }

  /**
   * Representation of the object based on the object current state.
   *
   * @return hashcode as integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getListings(), getCommissionRate(), getTotalEarnings());
  }

  /**
   * String expression of agent's information.
   *
   * @return agent's information as string.
   */
  @Override
  public String toString() {
    return "Agent{" +
        "name='" + name + '\'' +
        ", listings=" + listings +
        ", commissionRate=" + commissionRate +
        ", totalEarnings=" + totalEarnings +
        '}';
  }
}
