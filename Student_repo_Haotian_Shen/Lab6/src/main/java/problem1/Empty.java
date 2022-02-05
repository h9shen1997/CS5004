package problem1;

public class Empty implements List {

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
    return Boolean.FALSE;
  }

  @Override
  public Integer elementAt(Integer index) throws IndexOutOfBoundsException {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public Integer sum() {
    return 0;
  }
}
