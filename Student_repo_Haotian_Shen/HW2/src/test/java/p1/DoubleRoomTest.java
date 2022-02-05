package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DoubleRoomTest {

  DoubleRoom room;

  @Before
  public void setUp() throws Exception {
    room = new DoubleRoom(150.0, 0);
    if (room == null) {
      throw new NullPointerException("The DoubleRoom object has not been initialized yet");
    }
  }

  @Test(expected = RoomNotAvailableException.class)
  public void testBookRoomWhenRoomNotAvailable() {
    room.setNumberOfGuests(1);
    room.bookRoom(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBookRoomMoreThanCapacity() {
    room.setNumberOfGuests(0);
    room.bookRoom(3);
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
      room.bookRoom(2);
    } catch (RoomNotAvailableException e) {
      fail("The room is available and should not fail");
    } catch (IllegalArgumentException e) {
      fail("The number of guest is legal and should not fail");
    }
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(2, room.getMaxOccupancy(), 0);
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    room = new DoubleRoom(100.0, 0);
    DoubleRoom roomCopy = room;
    assertTrue(
        room.equals(roomCopy) && roomCopy.equals(room) && room.hashCode() == roomCopy.hashCode());
  }

  @Test
  public void testEqualsSameContentsDifferentAddress() {
    DoubleRoom room = new DoubleRoom(100.0, 0);
    DoubleRoom roomCopy = new DoubleRoom(100.0, 0);
    assertTrue(
        room.equals(roomCopy) && roomCopy.equals(room) && room.hashCode() == roomCopy.hashCode());
  }

  @Test
  public void testEqualsSingleRoomDoubleRoom() {
    room = new DoubleRoom(100.0, 0);
    FamilyRoom familyRoom = new FamilyRoom(100.0, 0);
    assertFalse(room.equals(familyRoom) || familyRoom.equals(room));
  }

  @Test
  public void testEqualsDifferentContents() {
    room = new DoubleRoom(100.0, 0);
    DoubleRoom roomCopy = new DoubleRoom(150.0, 0);
    assertFalse(room.equals(roomCopy) || roomCopy.equals(room));
  }
}