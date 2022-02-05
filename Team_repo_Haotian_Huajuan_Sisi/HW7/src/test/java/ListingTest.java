import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ListingTest {

  private Commercial com;
  private Sale sale;
  private Listing test;

  @Test
  public void getProperty() throws NonNegativeException {
    com = new Commercial("11123 Hill Street", 1300, 2, true);
    sale = new Sale(100000.0, false);
    test = new Listing(com, sale);
    assertEquals(com, test.getProperty());
  }

  @Test
  public void getContract() throws NonNegativeException {
    com = new Commercial("11123 Hill Street", 1300, 2, true);
    sale = new Sale(100000.0, false);
    test = new Listing(com, sale);
    assertEquals(sale, test.getContract());
  }

  @Test
  public void testEquals() throws NonNegativeException {
    com = new Commercial("11123 Hill Street", 1300, 2, true);
    sale = new Sale(100000.0, false);
    test = new Listing(com, sale);
    Listing test2 = test;
    assertTrue(test.equals(test2) && test2.equals(test));
  }

  @Test
  public void testHashCode() throws NonNegativeException {
    com = new Commercial("11123 Hill Street", 1300, 2, true);
    sale = new Sale(100000.0, false);
    test = new Listing(com, sale);
    Listing test2 = test;
    assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void testToString() throws NonNegativeException {
    com = new Commercial("11123 Hill Street", 1300, 2, true);
    sale = new Sale(100000.0, false);
    test = new Listing(com, sale);
    String expectedString =
        "Listing{property=Commercial{numOfOffices=2, ForRetail=true, address='11123 Hill Street', size=1300}, "
            + "contract=Sale{} Contract{askingPrice=100000.0, isNegotiable=false}}";
    assertEquals(expectedString, test.toString());
  }
}