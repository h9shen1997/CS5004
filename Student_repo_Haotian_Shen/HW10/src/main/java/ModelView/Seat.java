package ModelView;

import java.util.Objects;

/**
 * Seat class represents a seat. It stores information of whether the seat is occupied and who this
 * seat is reserved for.
 */
public class Seat {

  private boolean occupied;
  private String reservedFor;

  /**
   * Constructor for ModelView.Seat. The seat is unassigned and not occupied initially.
   */
  public Seat() {
    this.occupied = false;
  }

  /**
   * Getter for who reserve this seat.
   *
   * @return - String, the name of the person.
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /**
   * Getter for whether the seat is occupied.
   *
   * @return - boolean, whether occupied.
   */
  public boolean isOccupied() {
    return occupied;
  }

  /**
   * Reserve the seat given the person's name. This will make the seat occupied and reserved.
   *
   * @param reservedFor
   */
  public void reserve(String reservedFor) {
    this.reservedFor = reservedFor;
    this.occupied = true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    return occupied == seat.occupied && Objects.equals(reservedFor, seat.reservedFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(occupied, reservedFor);
  }

  @Override
  public String toString() {
    return "X";
  }
}
