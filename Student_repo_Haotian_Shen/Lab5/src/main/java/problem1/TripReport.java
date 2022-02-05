package problem1;

import java.util.Objects;

public class TripReport {

  private final Vehicle vehicleThatTookTrip;
  private final Float speed;
  private final Float traveledDistance;
  private final Integer tripDuration;

  public TripReport(Vehicle vehicleThatTookTrip, Float speed, Float traveledDistance,
      Integer tripDuration) {
    this.vehicleThatTookTrip = vehicleThatTookTrip;
    this.speed = speed;
    this.traveledDistance = traveledDistance;
    this.tripDuration = tripDuration;
  }

  public Vehicle getVehicleThatTookTrip() {
    return vehicleThatTookTrip;
  }

  public Float getSpeed() {
    return speed;
  }

  public Float getTraveledDistance() {
    return traveledDistance;
  }

  public Integer getTripDuration() {
    return tripDuration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TripReport)) {
      return false;
    }
    TripReport that = (TripReport) o;
    return getVehicleThatTookTrip().equals(that.getVehicleThatTookTrip()) && getSpeed().equals(
        that.getSpeed()) && getTraveledDistance().equals(that.getTraveledDistance())
        && getTripDuration().equals(that.getTripDuration());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVehicleThatTookTrip(), getSpeed(), getTraveledDistance(),
        getTripDuration());
  }

  @Override
  public String toString() {
    return "TripReport{" +
        "vehicleThatTookTrip=" + vehicleThatTookTrip +
        ", speed=" + speed +
        ", traveledDistance=" + traveledDistance +
        ", tripDuration=" + tripDuration +
        '}';
  }
}
