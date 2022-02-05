package p2;

/**
 * Interface for the set functionality.
 */
public interface SetFunctionality {

  Set emptySet();

  Boolean isEmpty();

  Set add(Integer n);

  Boolean contains(Integer n);

  Set remove(Integer n);

  Integer size();
}
