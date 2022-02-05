package problem2;

public class Vehicle {
  private String model;
  private int year;
  private String make;

  public Vehicle(String model, int year, String make) {
    this.model = model;
    this.year = year;
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public boolean isYoungerThanGivenYear(int year) {
    return getYear() < year;
  }

  public String getMake() {
    return make;
  }
}
