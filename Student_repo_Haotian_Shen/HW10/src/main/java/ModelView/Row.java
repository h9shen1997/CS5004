package ModelView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Row class extends ArrayList and represents a list of seats for that row. It also stores a current
 * filled index to indicate how many seats of the current row is already filled.
 */
public class Row extends ArrayList<Seat> {

  private static final String WHEELCHAIR_CHAR = "=";
  private static final String NON_WHEELCHAIR_CHAR = "_";
  private final List<Seat> rowSeats;
  private final int rowNumber;
  private final boolean wheelchairAccessible;
  private int curFilledIndex;

  /**
   * Constructor to create a row based on the row capacity, an assigned row number, and whether it
   * is wheelchair accessible.
   *
   * @param rowCapacity          - int, row capacity.
   * @param rowNumber            - int, row number, starting from 1.
   * @param wheelchairAccessible - boolean, whether it is wheelchair accessible.
   */
  public Row(int rowCapacity, int rowNumber, boolean wheelchairAccessible) {
    this.rowSeats = new ArrayList<>();
    for (int i = 0; i < rowCapacity; i++) {
      this.rowSeats.add(new Seat());
    }
    this.rowNumber = rowNumber;
    this.wheelchairAccessible = wheelchairAccessible;
    this.curFilledIndex = -1;
  }

  /**
   * Getter for the row capacity.
   *
   * @return - int, how many seats per row.
   */
  public int getCapacity() {
    return this.rowSeats.size();
  }

  /**
   * Getter for the current filled index.
   *
   * @return - int, currently, the index of the last seat that is filled.
   */
  public int getCurFilledIndex() {
    return curFilledIndex;
  }

  /**
   * Setter for the current filled index.
   *
   * @param curFilledIndex - int, current filled index.
   */
  public void setCurFilledIndex(int curFilledIndex) {
    this.curFilledIndex = curFilledIndex;
  }

  /**
   * Getter for all the seats of this row.
   *
   * @return - List<ModelView.Seat>, an arraylist of seats.
   */
  public List<Seat> getRowSeats() {
    return rowSeats;
  }

  /**
   * Getter for the row number, starting from 1.
   *
   * @return - int, the row number.
   */
  public int getRowNumber() {
    return rowNumber;
  }

  /**
   * Getter for whether the row is wheelchair accessible.
   *
   * @return - boolean, whether the row is wheelchair accessible.
   */
  public boolean isWheelchairAccessible() {
    return wheelchairAccessible;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return rowNumber == seats.rowNumber && wheelchairAccessible == seats.wheelchairAccessible
        && curFilledIndex == seats.curFilledIndex && Objects.equals(rowSeats,
        seats.rowSeats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowSeats, rowNumber, wheelchairAccessible,
        curFilledIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < getRowSeats().size(); i++) {
      boolean occupied = getRowSeats().get(i).isOccupied();
      sb.append(occupied ? getRowSeats().get(i).toString()
          : isWheelchairAccessible() ? WHEELCHAIR_CHAR : NON_WHEELCHAIR_CHAR);
      sb.append(" ");
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }
}
