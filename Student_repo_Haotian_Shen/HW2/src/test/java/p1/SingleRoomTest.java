package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SingleRoomTest {

  SingleRoom room;

  @Before
  public void setUp() throws Exception {
    room = new SingleRoom(100.0, 0);
    if (room == null) {
      throw new NullPointerException("The SingleRoom object has not been initialized yet");
    }
  }

  @Test(expected = RoomNotAvailableException.class)
  public void testBookRoomWhenRoomNotAvailable() {
    room.setNumberOfGuests(1);
    room.bookRoom(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBookRoomMoreThanCapacity() {
    room.setNumberOfGuests(0);
    room.bookRoom(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBookRoomLessThanZero() {
    room.setNumberOfGuests(0);
    room.bookRoom(-1);
  }

  @Test
  public void testBookRoomCorrectPeopleAndAvailable() {
    try {
      room.setNumberOfGuests(0);
      room.bookRoom(1);
    } catch (RoomNotAvailableException e) {
      fail("The room is available and should not fail");
    } catch (IllegalArgumentException e) {
      fail("The number of guest is legal and should not fail");
    }
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(1, room.getMaxOccupancy(), 0);
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    room = new SingleRoom(100.0, 0);
    SingleRoom roomCopy = room;
    assertTrue(
        room.equals(roomCopy) && roomCopy.equals(room) && room.hashCode() == roomCopy.hashCode());
  }

  @Test
  public void testEqualsSameContentsDifferentAddress() {
    SingleRoom room = new SingleRoom(100.0, 0);
    SingleRoom roomCopy = new SingleRoom(50.0, 0);
    assertFalse(
        room.equals(roomCopy) || roomCopy.equals(room));
  }

  @Test
  public void testEqualsSingleRoomDoubleRoom() {
    room = new SingleRoom(100.0, 0);
    DoubleRoom doubleRoom = new DoubleRoom(100.0, 0);
    assertFalse(room.equals(doubleRoom) || doubleRoom.equals(room));
  }

  @Test
  public void testEqualsDifferentContents() {
    room = new SingleRoom(100.0, 0);
    SingleRoom roomCopy = new SingleRoom(150.0, 0);
    assertFalse(room.equals(roomCopy) || roomCopy.equals(room));
  }
}