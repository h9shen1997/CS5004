package problem1;

public interface List {
  Integer size();
  Boolean isEmpty();
  List add(Integer element);
  Integer last();
  Boolean contains(Integer element);
  Integer elementAt(Integer index) throws IndexOutOfBoundsException;
  Integer sum();
}
