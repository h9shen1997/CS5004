package p1;

import java.util.Objects;

/**
 * A double room object that inherited from room class, which has the functionality of price per
 * night, number of guests, and max occupancy of 2.
 */
public class DoubleRoom extends Room {

  private static final Integer DOUBLE_ROOM_OCCUPANCY = 2;
  private final Integer maxOccupancy;

  /**
   * Constructor that creates a double room with price per night and number of guest in it.
   *
   * @param pricePerNight  - Double, price per night
   * @param numberOfGuests - Integer, number of guest
   */
  public DoubleRoom(Double pricePerNight, Integer numberOfGuests) {
    super(pricePerNight, numberOfGuests);
    this.maxOccupancy = DOUBLE_ROOM_OCCUPANCY;
  }

  /**
   * Getter for max occupancy.
   *
   * @return Integer, max occupancy.
   */
  public Integer getMaxOccupancy() {
    return this.maxOccupancy;
  }

  /**
   * Book room using the number of guest provided.
   *
   * @param numberOfGuests - Integer, number of guests.
   * @throws RoomNotAvailableException if the room is not available.
   * @throws IllegalArgumentException  if the number of guest is less than 1 or greater than the
   *                                   capacity of the room.
   */
  @Override
  public void bookRoom(Integer numberOfGuests)
      throws RoomNotAvailableException, IllegalArgumentException {
    if (!this.isAvailable()) {
      throw new RoomNotAvailableException("The room has already been occupied");
    }
    if (numberOfGuests <= 0 || numberOfGuests > getMaxOccupancy()) {
      throw new IllegalArgumentException(
          "The number of guest in the double room needs to be greater than 0 and smaller than 2");
    }
    this.setNumberOfGuests(numberOfGuests);
  }

  /**
   * Compare whether two double room objects are equal.
   *
   * @param o - Object, the double room to be compared.
   * @return - Boolean, whether two double room objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DoubleRoom)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    DoubleRoom that = (DoubleRoom) o;
    return getMaxOccupancy().equals(that.getMaxOccupancy());
  }

  /**
   * Generate hashcode for the double room object.
   *
   * @return - int, hashcode for the double room object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMaxOccupancy());
  }
}



