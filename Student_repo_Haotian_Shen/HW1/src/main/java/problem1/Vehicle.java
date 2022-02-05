package problem1;

/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number (VIN), and
 * corresponding license plate.
 */
public class Vehicle {

  private Integer VIN;
  private String licensePlate;
  private Owner owner;

  /**
   * Constructor that creates a new vehicle with the specified VIN and license plate.
   *
   * @param VIN          -VIN of the new Vehicle.
   * @param licensePlate -license plate of the new Vehicle.
   */
  public Vehicle(Integer VIN, String licensePlate, Owner owner) {
    this.VIN = VIN;
    this.licensePlate = licensePlate;
    this.owner = owner;
  }

  /**
   * Returns the owner of the Vehicle.
   *
   * @return the owner of the Vehicle.
   */
  public Owner getOwner() {
    return owner;
  }

  /**
   * Sets the owner of the Vehicle.
   *
   * @param owner - new owner for the Vehicle.
   */
  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  /**
   * Returns the VIN of the Vehicle.
   *
   * @return the VIN of the Vehicle.
   */
  public Integer getVIN() {
    return this.VIN;
  }

  /**
   * Sets the VIN of the Vehicle.
   *
   * @param VIN - new VIN of the Vehicle.
   */
  public void setVIN(Integer VIN) {
    this.VIN = VIN;
  }

  /**
   * Returns the licensePlate of the Vehicle.
   *
   * @return the licensePlate of the Vehicle.
   */
  public String getLicensePlate() {
    return this.licensePlate;
  }

  /**
   * Sets the licensePlate of the Vehicle with the specified licensePlate.
   *
   * @param licensePlate - new licensePlate of the Vehicle
   */
  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }
}
