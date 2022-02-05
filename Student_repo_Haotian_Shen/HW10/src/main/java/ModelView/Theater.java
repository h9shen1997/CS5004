package ModelView;

import Exceptions.NoSeatsAvailableException;
import Exceptions.NoWheelchairRowException;
import java.util.Arrays;
import java.util.Objects;

/**
 * Theater class is the model and view of the theater. It will contain information about how many
 * rows the theater has and the name of the theater. It will also contain information about which
 * rows in the theater is wheelchair accessible.
 */
public class Theater {

  private static final int TWO_DIVISOR = 2;
  private final String name;
  private final Row[] rows;
  private final int[] wheelchairRows;

  /**
   * Constructor for theater based on the number of rows, each row's capacity, the theater name, and
   * the rows designated for wheelchair access.
   *
   * @param numOfRow       - int, the number of rows in the theater.
   * @param rowCapacity    - int, each row's seat capacity.
   * @param name           - String, the name of the theater.
   * @param wheelchairRows - int[], the rows for wheelchair access.
   * @throws NoWheelchairRowException If no wheelchair access row is given.
   */
  public Theater(int numOfRow, int rowCapacity, String name, int[] wheelchairRows)
      throws NoWheelchairRowException {
    if (wheelchairRows == null || wheelchairRows.length == 0) {
      throw new NoWheelchairRowException(
          "It is impossible to create a theater without at least one accessible wheelchair row.");
    }
    if (numOfRow < 1 || numOfRow < wheelchairRows.length) {
      throw new IllegalArgumentException(
          "The number of row need to be at least 1 and greater than the number of wheelchair rows specified.");
    }
    this.name = name;
    this.rows = new Row[numOfRow];
    this.wheelchairRows = wheelchairRows;
    for (int rowNumber : wheelchairRows) {
      if (rowNumber > numOfRow) {
        throw new IllegalArgumentException(
            "The specified wheelchair row cannot be greater than the maximum row within this theater.");
      }
      this.rows[rowNumber - 1] = new Row(rowCapacity, rowNumber, true);
    }
    for (int i = 0; i < numOfRow; i++) {
      if (this.rows[i] == null) {
        this.rows[i] = new Row(rowCapacity, i + 1, false);
      }
    }
  }

  /**
   * Getter for the theater name.
   *
   * @return the name of the theater.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for all the rows of the theater.
   *
   * @return all the rows of the theater.
   */
  private Row[] getRows() {
    return rows;
  }

  public int getRowCapacity() {
    return getRows()[0].getCapacity();
  }

  /**
   * Show the current seating in the theater. Using a string builder to build the rows based on
   * whether the row is wheelchair accessible or not. If the seat is already occupied, display it as
   * X.
   */
  public void show() {
    System.out.println(this);
  }

  /**
   * Get the previous and next row in regard to center row in the theater as an integer array. The
   * first element in the array is the previous row and the second is the next row.
   *
   * @return - int[], an integer array containing two elements to represent the previous and next
   * rows.
   */
  private int[] getPrevAndNextIndexOfCenterRow() {
    int centerRowIndex = this.rows.length / TWO_DIVISOR;
    return new int[]{this.rows.length % TWO_DIVISOR == 0 ? centerRowIndex - 1 : centerRowIndex,
        centerRowIndex};
  }

  /**
   * Get the optimal row based on the amount of people and whether the wheelchair accessible row is
   * needed. The optimal row is based on proximity to the center. If wheelchair accessible row is
   * required, the user need to find the proximal wheelchair row and assign seats. If no wheelchair
   * accessible row is required, the user need to first find the proximal non-wheelchair row and
   * assign seats. In the case that no non-wheelchair exists, the user can be assigned to wheelchair
   * row.
   *
   * @param people            - int, the number of people booking.
   * @param needWheelchairRow - boolean, whether the booking need wheelchair row.
   * @return - int, the optimal row.
   * @throws NoSeatsAvailableException If there is no room to accommodate the whole party.
   */
  public int getOptimalRow(int people, boolean needWheelchairRow) throws NoSeatsAvailableException {
    int rowCapacity = getRowCapacity();
    int numOfRows = getRows().length;
    if (people > rowCapacity) {
      throw new NoSeatsAvailableException();
    }
    int[] prevAndNextIndexOfCenterRow = getPrevAndNextIndexOfCenterRow();
    int prevRowIndexOfCenter = prevAndNextIndexOfCenterRow[0];
    int nextRowIndexOfCenter = prevAndNextIndexOfCenterRow[1];
    int indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft = -1;
    while (prevRowIndexOfCenter >= 0 && nextRowIndexOfCenter < numOfRows) {
      Row prevRow = getRows()[prevRowIndexOfCenter];
      Row nextRow = getRows()[nextRowIndexOfCenter];
      int prevRowRemainingSeats =
          this.rows[prevRowIndexOfCenter].getCapacity()
              - this.rows[prevRowIndexOfCenter].getCurFilledIndex() - 1;
      int nextRowRemainingSeats =
          this.rows[nextRowIndexOfCenter].getCapacity()
              - this.rows[nextRowIndexOfCenter].getCurFilledIndex() - 1;
      if (needWheelchairRow) {
        if (prevRow.isWheelchairAccessible()) {
          if (prevRowRemainingSeats >= people) {
            return prevRowIndexOfCenter + 1;
          }
        }
        if (nextRow.isWheelchairAccessible()) {
          if (nextRowRemainingSeats >= people) {
            return nextRowIndexOfCenter + 1;
          }
        }
      } else {
        if (!prevRow.isWheelchairAccessible()) {
          if (prevRowRemainingSeats >= people) {
            return prevRowIndexOfCenter + 1;
          }
        } else {
          if (prevRowRemainingSeats >= people
              && indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft == -1) {
            indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft = prevRowIndexOfCenter;
          }
        }
        if (!nextRow.isWheelchairAccessible()) {
          if (nextRowRemainingSeats >= people) {
            return nextRowIndexOfCenter + 1;
          }
        } else {
          if (nextRowRemainingSeats >= people
              && indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft == -1) {
            indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft = nextRowIndexOfCenter;
          }
        }
      }
      prevRowIndexOfCenter--;
      nextRowIndexOfCenter++;
    }
    if (indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft != -1) {
      return indexOfWheelchairRowCanBeUsedIfNoNormalSeatsLeft + 1;
    }
    throw new NoSeatsAvailableException();
  }

  /**
   * Change the seats to occupied based on the number of people, reserved for name, and wheelchair
   * access requirements.
   *
   * @param people            - int, number of people for the booking.
   * @param name              - String, the name of the booking person.
   * @param needWheelchairRow - boolean, whether wheelchair is required.
   * @return - int, the optimal row for the booking process. This will be used to display
   * confirmation message in the controller.
   * @throws NoSeatsAvailableException If there is no room to accommodate the whole party.
   */
  public int changeSeatsToOccupied(int people, String name, boolean needWheelchairRow)
      throws NoSeatsAvailableException {
    int optimalRow = getOptimalRow(people, needWheelchairRow);
    int optimalRowIndex = optimalRow - 1;
    int seatIndex = 1;
    Row row = this.rows[optimalRowIndex];
    int curFilledIndex = row.getCurFilledIndex();
    while (seatIndex <= people) {
      row.getRowSeats().get(curFilledIndex + seatIndex).reserve(name);
      seatIndex++;
    }
    row.setCurFilledIndex(seatIndex + curFilledIndex - 1);
    return optimalRow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Theater theater = (Theater) o;
    return Objects.equals(name, theater.name) && Arrays.equals(rows, theater.rows)
        && Arrays.equals(wheelchairRows, theater.wheelchairRows);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(name);
    result = 31 * result + Arrays.hashCode(rows);
    result = 31 * result + Arrays.hashCode(wheelchairRows);
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows.length - 1; i++) {
      sb.append(rows[i].toString());
      sb.append(System.lineSeparator());
    }
    sb.append(rows[rows.length - 1]);
    return sb.toString();
  }
}
