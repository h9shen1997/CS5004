package p1;

import java.util.Objects;

/**
 * SingleRoom object inherited from Room object, which has the functionality of price per night,
 * number of guests, and max occupancy of 1.
 */
public class SingleRoom extends Room {

  private static final Integer SINGLE_ROOM_OCCUPANCY = 1;
  private final Integer maxOccupancy;

  /**
   * Constructor that creates a SingleRoom object that has price per night, number of guests and max
   * occupancy of 1.
   *
   * @param pricePerNight  - Double, price per night.
   * @param numberOfGuests - Integer, number of guests.
   */
  public SingleRoom(Double pricePerNight, Integer numberOfGuests) {
    super(pricePerNight, numberOfGuests);
    this.maxOccupancy = SINGLE_ROOM_OCCUPANCY;
  }

  /**
   * Getter for max occupancy.
   *
   * @return - Integer, max occupancy.
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
          "The number of guest in the single room needs to be greater than 0 and smaller than 1");
    }
    this.setNumberOfGuests(numberOfGuests);
  }

  /**
   * Compare whether two single room objects are equal.
   *
   * @param o - Object, the single room to be compared.
   * @return - Boolean, whether two single room objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SingleRoom)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SingleRoom that = (SingleRoom) o;
    return getMaxOccupancy().equals(that.getMaxOccupancy());
  }

  /**
   * Generate hashcode for the single room object.
   *
   * @return - int, hashcode for the single room object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMaxOccupancy());
  }


}
