package p1;

public abstract class Food {

  protected String name;
  protected Double pricePerUnit;
  protected Integer curAvailableQuantity;

  public Food(String name, Double pricePerUnit, Integer curAvailableQuantity) {
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.curAvailableQuantity = curAvailableQuantity;
  }

  public String getName() {
    return name;
  }

  public Double getPricePerUnit() {
    return pricePerUnit;
  }

  public Integer getCurAvailableQuantity() {
    return curAvailableQuantity;
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Food)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    Food food = (Food) object;
    return java.util.Objects.equals(getName(), food.getName()) && java.util.Objects.equals(
        getPricePerUnit(), food.getPricePerUnit()) && java.util.Objects.equals(
        getCurAvailableQuantity(), food.getCurAvailableQuantity());
  }

  public int hashCode() {
    return java.util.Objects.hash(super.hashCode(), getName(), getPricePerUnit(),
        getCurAvailableQuantity());
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "Food{" +
        "name='" + name + '\'' +
        ", pricePerUnit=" + pricePerUnit +
        ", curAvailableQuantity=" + curAvailableQuantity +
        '}';
  }
}
