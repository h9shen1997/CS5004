package p1;

import java.util.Objects;

/**
 * FamilyRoom object inherited from Room to provide the functionality of a room that has maximum
 * occupancy of 4.
 */
public class FamilyRoom extends Room {

  private static final Integer FAMILY_ROOM_OCCUPANCY = 4;
  private final Integer maxOccupancy;

  /**
   * Constructor that creates a FamilyRoom object with price per night and number of guest and max
   * occupancy of 4.
   *
   * @param pricePerNight  - Double, price per night.
   * @param numberOfGuests - Integer, number of guests.
   */
  public FamilyRoom(Double pricePerNight, Integer numberOfGuests) {
    super(pricePerNight, numberOfGuests);
    this.maxOccupancy = FAMILY_ROOM_OCCUPANCY;
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
          "The number of guest in the family room needs to be greater than 0 and smaller than 4");
    }
    this.setNumberOfGuests(numberOfGuests);
  }

  /**
   * Compare whether two family room objects are equal.
   *
   * @param o - Object, the family room to be compared.
   * @return - Boolean, whether two family room objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FamilyRoom)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    FamilyRoom that = (FamilyRoom) o;
    return getMaxOccupancy().equals(that.getMaxOccupancy());
  }

  /**
   * Generate hashcode for the family room object.
   *
   * @return - int, hashcode for the family room object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMaxOccupancy());
  }
}




