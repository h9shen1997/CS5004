package problem1;

public class FleatManager {

  public TripReport drive(float distance, Vehicle vehicle) {
    Float duration;
    if (vehicle.getAverageSpeed() > 0) {
      duration = distance / vehicle.getAverageSpeed();
    } else {
      throw new IllegalArgumentException("Average speed of a vehicle cannot be zero");
    }
    return new TripReport(vehicle, vehicle.getAverageSpeed(), distance, Math.round(duration));
  }

  public TripReport drive(float distance, Vehicle vehicle, Float speed, Integer duration) {
    return new TripReport(vehicle, speed, distance, duration);
  }

  public TripReport drive(float distance, Vehicle vehicle, Float speed) {
    Float duration;
    if (speed > 0) {
      duration = distance / speed;
    } else {
      throw new IllegalArgumentException("Speed cannot be zero");
    }
    return new TripReport(vehicle, speed, distance, Math.round(duration));
  }

  public TripReport drive(Vehicle vehicle, Float speed, Integer duration) {
    Float distance = duration * speed;
    return new TripReport(vehicle, speed, distance, duration);
  }

  public TripReport drive(Bus bus, float distance, Float speed, Integer duration) {
    return new TripReport(bus, speed, distance, duration);
  }

  public TripReport drive(Train train, float distance, Float speed, Integer duration) {
    return new TripReport(train, speed, distance, duration);
  }
}
