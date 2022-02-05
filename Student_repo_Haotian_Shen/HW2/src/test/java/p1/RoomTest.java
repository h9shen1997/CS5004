package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {

  Room room;

  @Before
  public void setUp() throws Exception {
    room = new FamilyRoom(250.0, 0);
  }

  @Test
  public void getPricePerNight() {
    assertEquals(250.0, room.getPricePerNight(), 0.0);
  }

  @Test
  public void setPricePerNight() {
    room.setPricePerNight(300.0);
    assertEquals(300.0, room.getPricePerNight(), 0.0);
  }

  @Test
  public void getNumberOfGuests() {
    assertEquals(0, room.getNumberOfGuests(), 0);
  }

  @Test
  public void setNumberOfGuests() {
    room.setNumberOfGuests(3);
    assertEquals(3, room.getNumberOfGuests(), 0);
  }

  @Test
  public void isAvailableWhenGuestIsZero() {
    room.setNumberOfGuests(0);
    assertTrue(room.isAvailable());
  }

  @Test
  public void isAvailableWhenGuestIsGreaterThanZero() {
    room.setNumberOfGuests(2);
    assertFalse(room.isAvailable());
  }
}