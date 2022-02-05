package problem2;

public class EmptySet implements RecursiveSet {

  @Override
  public RecursiveSet emptySet() {
    return new EmptySet();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public RecursiveSet add(Integer n) {
    return new EmptySet();
  }

  @Override
  public Boolean contains(Integer n) {
    return Boolean.FALSE;
  }

  @Override
  public RecursiveSet remove(Integer n) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }
}
