package problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Band class represents a collection of creator as the member of the band. It also has a band
 * name.
 */
public class Band {

  private final String bandName;
  private final Set<Creator> members;

  /**
   * Constructor that creates a Band object with the band name and a set of members.
   *
   * @param bandName - String, band name.
   * @param members  - Set<Creator>, all the members.
   */
  public Band(String bandName, Set<Creator> members) {
    this.bandName = bandName;
    this.members = new HashSet<>(members);
  }

  /**
   * Add a member to the band.
   *
   * @param creator - Creator, new member.
   */
  public void addBandMember(Creator creator) throws IllegalArgumentException {
    if (!creator.isAuthor()) {
      this.members.add(creator);
    } else {
      throw new IllegalArgumentException("The creator can only be a recording artist.");
    }
  }

  /**
   * Remove a member from the band.
   *
   * @param creator - Creator, removed member.
   */
  public void removeBandMember(Creator creator) throws IllegalArgumentException {
    if (!creator.isAuthor()) {
      this.members.remove(creator);
    } else {
      throw new IllegalArgumentException("The creator can only be a recording artist.");
    }
  }

  /**
   * Getter for the band name.
   *
   * @return - String, band name.
   */
  public String getBandName() {
    return bandName;
  }

  /**
   * Getter for the members.
   *
   * @return - Set<Creator>, the members.
   */
  public Set<Creator> getMembers() {
    return members;
  }

  /**
   * Compare whether two Band objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Band)) {
      return false;
    }
    Band band = (Band) o;
    return getBandName().equals(band.getBandName()) && getMembers().equals(band.getMembers());
  }

  /**
   * Generate hashcode for the Band object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getBandName(), getMembers());
  }

  /**
   * String expression for the Band object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Band{" +
        "bandName='" + bandName + '\'' +
        ", members=" + members +
        '}';
  }
}
