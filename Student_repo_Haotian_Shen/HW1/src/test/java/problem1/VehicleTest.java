package problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

  private final Owner owner = new Owner("Haotian", "Shen", "6787994644");
  Vehicle vehicle;

  @Before
  public void setUp() throws NullPointerException {
    vehicle = new Vehicle(937492839, "BSJ2939", owner);
    if (vehicle == null) {
      throw new NullPointerException("The vehicle object has not been initialized yet.");
    }
  }

  @Test
  public void getVIN() {
    Integer expectedVIN = 937492839;
    assertEquals("The vehicle VIN must be 937492839", expectedVIN,
        vehicle.getVIN());
  }

  @Test
  public void setVIN() {
    Integer expectedVIN = 937492840;
    vehicle.setVIN(expectedVIN);
    assertEquals("The vehicle VIN should be changed to 937492840",
        expectedVIN, vehicle.getVIN());
  }

  @Test
  public void getLicensePlate() {
    String expectedLicensePlate = "BSJ2939";
    assertEquals("The vehicle license plate must be BSJ2939",
        expectedLicensePlate, vehicle.getLicensePlate());
  }

  @Test
  public void setLicensePlate() {
    String expectedLicensePlate = "BSJ2940";
    vehicle.setLicensePlate(expectedLicensePlate);
    assertEquals("The vehicle license plate should be changed to BSJ2940",
        expectedLicensePlate, vehicle.getLicensePlate());
  }

  @Test
  public void getOwner() {
    assertEquals("The owner's first name must be Haotian",
        owner.getFirstName(), vehicle.getOwner().getFirstName());
    assertEquals("The owner's last name must be Shen", owner.getLastName(),
        vehicle.getOwner().getLastName());
    assertEquals("The owner's phone number must be 6787994644",
        owner.getPhoneNumber(), vehicle.getOwner().getPhoneNumber());
  }

  @Test
  public void setOwner() {
    Owner expectedOwner = new Owner("Shen", "Haotian", "6787994645");
    vehicle.setOwner(expectedOwner);
    assertEquals("The owner's first name should be changed to Shen", expectedOwner.getFirstName(),
        vehicle.getOwner().getFirstName());
    assertEquals("The owner's last name should be changed to Haotian", expectedOwner.getLastName(),
        vehicle.getOwner().getLastName());
    assertEquals("The owner's phone number should be changed to 6787994645",
        expectedOwner.getPhoneNumber(), vehicle.getOwner().getPhoneNumber());
  }
}