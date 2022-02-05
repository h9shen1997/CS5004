package problem3;

public interface ListOfList {
  Integer size();
  Integer length();
  Integer sum();
  Boolean isEmpty();
  ListOfList add(Integer n);
  ListOfList removeInteger(Integer n);
  ListOfList removeAllInteger(Integer n);
}
