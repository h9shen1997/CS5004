package problem1;

import java.util.Objects;

public class Vehicle {

  protected String ID;
  protected Float averageSpeed;
  protected Float maxSpeed;

  public String getID() {
    return ID;
  }

  public Float getAverageSpeed() {
    return averageSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Vehicle)) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return getID().equals(vehicle.getID()) && getAverageSpeed().equals(vehicle.getAverageSpeed())
        && getMaxSpeed().equals(vehicle.getMaxSpeed());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getID(), getAverageSpeed(), getMaxSpeed());
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "ID='" + ID + '\'' +
        ", averageSpeed=" + averageSpeed +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
