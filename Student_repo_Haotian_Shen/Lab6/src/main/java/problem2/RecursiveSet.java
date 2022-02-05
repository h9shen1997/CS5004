package problem2;

public interface RecursiveSet {
  RecursiveSet emptySet();
  Boolean isEmpty();
  RecursiveSet add(Integer n);
  Boolean contains(Integer n);
  RecursiveSet remove(Integer n);
  Integer size();
}
