package p2;

public interface List {
  Boolean isEmpty();
  Integer size();
  Boolean contains(String element);
  Boolean containsAll(List elements);
  Boolean hasDuplicate();
  List removeDuplicate();
}
