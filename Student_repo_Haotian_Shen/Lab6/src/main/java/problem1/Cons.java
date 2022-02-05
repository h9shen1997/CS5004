package problem1;

public class Cons implements List {
  private Integer first;
  private Cons rest;

  @Override
  public Integer size() {
    return null;
  }

  @Override
  public Boolean isEmpty() {
    return null;
  }

  @Override
  public List add(Integer element) {
    return null;
  }

  @Override
  public Integer last() {
    return null;
  }

  @Override
  public Boolean contains(Integer element) {
    if(this.first.equals(element)) {
      return Boolean.TRUE;
    } else {
      return this.rest.contains(element);
    }
  }

  @Override
  public Integer elementAt(Integer index) throws IndexOutOfBoundsException {
    if(index < 0 || index > this.size()) {
      throw new IndexOutOfBoundsException();
    } else if(index.equals(0)) {
      return this.first;
    } else {
      return this.rest.elementAt(index - 1);
    }
  }

  @Override
  public Integer sum() {
    return 0;
  }
}
