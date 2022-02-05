package problem2;

import java.util.Objects;

public class NonEmptySet implements RecursiveSet {

  private Integer headValue;
  private RecursiveSet rest;

  public NonEmptySet(Integer headValue, RecursiveSet rest) {
    this.headValue = headValue;
    this.rest = rest;
  }

  public Integer getHeadValue() {
    return headValue;
  }

  public RecursiveSet getRest() {
    return rest;
  }

  @Override
  public RecursiveSet emptySet() {
    return new EmptySet();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public RecursiveSet add(Integer n) {
    if(this.contains(n)) {
      return this;
    } else {
      return new NonEmptySet(n, this);
    }
  }

  @Override
  public Boolean contains(Integer n) {
    if(this.headValue.equals(n)) {
      return Boolean.TRUE;
    } else {
      return this.rest.contains(n);
    }
  }

  @Override
  public RecursiveSet remove(Integer n) {
    if(!this.contains(n)) {
      return this;
    } else if(this.headValue.equals(n)) {
      return this.rest;
    } else {
      return new NonEmptySet(this.headValue, this.rest.remove(n));
    }
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonEmptySet)) {
      return false;
    }
    NonEmptySet that = (NonEmptySet) o;
    Integer originalSize = this.size();
    if(originalSize.equals(that.size())) {
      return this.helper(that);
    }
    return false;
  }

  private boolean helper(NonEmptySet set) {
    if(set.isEmpty()) {
      return true;
    }
    if(set.contains(this.headValue)) {
      return helper((NonEmptySet) set.remove(this.headValue));
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getHeadValue(), getRest());
  }

  @Override
  public String toString() {
    return "NonEmptySet{" +
        "headValue=" + headValue +
        ", rest=" + rest +
        '}';
  }
}
