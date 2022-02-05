package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehicleFilter {
  private static Integer FILTER_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();

  public OlderVehicleFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public OlderVehicleFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  public void filterOlderVehicle() {
    System.out.println(vehicles.stream().filter(x -> x.isYoungerThanGivenYear(FILTER_YEAR)).map(x -> "Vehicle: " + x.getMake() + " " +
        x.getModel() + " " + x.getYear()).collect((Collectors.joining(";"))));
  }
}
