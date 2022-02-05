package p1;

import java.util.Objects;

/**
 * Abstract class Room define the structure of a room in the hotel. It should have a price per
 * night, number of guests.
 */
public abstract class Room {

  protected Double pricePerNight;
  protected Integer numberOfGuests;

  /**
   * General constructor structure for a general Room object.
   *
   * @param pricePerNight  - Double, price per night.
   * @param numberOfGuests - Integer, number of guests.
   */
  public Room(Double pricePerNight, Integer numberOfGuests) {
    this.pricePerNight = pricePerNight;
    this.numberOfGuests = numberOfGuests;
  }

  /**
   * Getter for price per night.
   *
   * @return - Double, price per night.
   */
  public Double getPricePerNight() {
    return this.pricePerNight;
  }

  /**
   * Setter for price per night.
   *
   * @param pricePerNight - Double, price per night.
   */
  public void setPricePerNight(Double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  /**
   * Getter for number of guests.
   *
   * @return - Integer, number of guests.
   */
  public Integer getNumberOfGuests() {
    return this.numberOfGuests;
  }

  /**
   * Setter for number of guests.
   *
   * @param numberOfGuests - Integer, number of guests.
   */
  public void setNumberOfGuests(Integer numberOfGuests) {
    this.numberOfGuests = numberOfGuests;
  }

  /**
   * Check if the current room is available by checking if it has any guests in it.
   *
   * @return - Boolean, if the room if available.
   */
  public boolean isAvailable() {
    return this.numberOfGuests == 0;
  }

  /**
   * Book room using the provided number of guests.
   *
   * @param numberOfGuests - Integer, number of guests.
   * @throws IllegalArgumentException if the number of guests is less than 1 or greater than the
   *                                  room's capacity.
   */
  public abstract void bookRoom(Integer numberOfGuests) throws IllegalArgumentException;

  /**
   * Compare whether two general Room objects are equal.
   *
   * @param o - Object, the room object to be compared.
   * @return - Boolean, whether the two room objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Room)) {
      return false;
    }
    Room room = (Room) o;
    return getPricePerNight().equals(room.getPricePerNight()) && getNumberOfGuests().equals(
        room.getNumberOfGuests());
  }

  /**
   * Generate hashcode based on the price per night and number of guests of the Room object.
   *
   * @return - int, the hashcode of the Room object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getPricePerNight(), getNumberOfGuests());
  }
}
