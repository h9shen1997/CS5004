import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class AgentTest {

  private Agent test;
  private Residential res;
  private Rental rent;

  @Test(expected = CommissionRateException.class)
  public void testInvalidCommissionRate() throws CommissionRateException {
    test = new Agent("Lily", 1.5);
  }

  @Test
  public void addListing() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    test.addListing(new Listing(res, rent));
    assertEquals(1, test.getListings().size());
  }

  @Test
  public void completeListing()
      throws ListingNotFoundException, CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    test.addListing(new Listing(res, rent));
    test.completeListing(new Listing(res, rent));
    assertEquals(0, test.getListings().size());
  }

  @Test
  public void dropListing()
      throws ListingNotFoundException, CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    test.addListing(new Listing(res, rent));
    test.dropListing(new Listing(res, rent));
    assertEquals(0, test.getListings().size());
  }

  @Test
  public void getTotalPortfolioValue()
      throws ListingNotFoundException, CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    test.addListing(new Listing(res, rent));
    test.completeListing(new Listing(res, rent));
    assertEquals(120.0, test.getTotalPortfolioValue(), 1e-6);
  }

  @Test
  public void getName() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    assertEquals(test.getName(), "Lisa");
  }

  @Test
  public void getListings() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    assertEquals(new HashSet(), test.getListings());
  }

  @Test
  public void getCommissionRate() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    assertEquals(0.02, test.getCommissionRate(), 1e-6);
  }

  @Test
  public void getTotalEarnings() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    assertEquals(0.0, test.getTotalEarnings(), 1e-6);
  }

  @Test
  public void testEqualIsSameMemoryAddress() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    Agent test2 = test;
    assertTrue(test.equals(test2) && test2.equals(test) && test.hashCode() == test2.hashCode());
  }

  @Test
  public void testEqualsDifferentContent() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    Agent test2 = new Agent("Lily", 0.01);
    assertFalse(test2.equals(test) || test.equals(test2));
  }

  @Test
  public void testEqualsDifferentClass() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    Agent test2 = new Agent("Lily", 0.01);
    assertFalse(test2.equals(test) || test.equals(test2));
  }

  @Test
  public void testToString() throws CommissionRateException, NonNegativeException {
    test = new Agent("Lisa", 0.02);
    res = new Residential("11123 Hill Street", 1300, 2, 2.0);
    rent = new Rental(1000.0, false, 6);
    test.addListing(new Listing(res, rent));
    String expectedString =
        "Agent{name='Lisa', listings=[Listing{property=Residential{address='11123 Hill Street', size=1300, numOfRooms=2, numOfBathrooms=2.0}, "
            + "contract=Rental{term=6} Contract{askingPrice=1000.0, isNegotiable=false}}], commissionRate=0.02, totalEarnings=0.0}";
    assertEquals(expectedString, test.toString());
  }
}