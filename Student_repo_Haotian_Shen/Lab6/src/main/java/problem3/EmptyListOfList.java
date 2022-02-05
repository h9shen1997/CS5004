package problem3;

import problem1.List;

public class EmptyListOfList implements ListOfList {

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Integer length() {
    return 0;
  }

  @Override
  public Integer sum() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public ListOfList add(Integer n) {
    return null;
  }

  public ListOfList add(List n) {
    return new NonEmptyListOfList(n, this);
  }

  @Override
  public ListOfList removeInteger(Integer n) {
    return null;
  }

  @Override
  public ListOfList removeAllInteger(Integer n) {
    return null;
  }
}
