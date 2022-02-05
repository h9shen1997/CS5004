package problem3;

import problem1.List;

public class NonEmptyListOfList implements ListOfList {
  private List headList;
  private ListOfList rest;

  public NonEmptyListOfList(List headList, ListOfList rest) {
    this.headList = headList;
    this.rest = rest;
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public Integer length() {
    return this.headList.size() + this.rest.length();
  }

  @Override
  public Integer sum() {
    return this.headList.sum() + this.rest.sum();
  }

  @Override
  public Boolean isEmpty() {
    return false;
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
    if(this.headList.contains(n)) {
      // return new NonEmptyListOfList(this.headList.remove(n), this.rest);
    } else {
      return new NonEmptyListOfList(this.headList, this.rest.removeInteger(n));
    }
    return null;
  }

  @Override
  public ListOfList removeAllInteger(Integer n) {
    return null;
  }
}
