package p1;

import java.time.LocalDate;

public abstract class PerishableFood extends Food {

  protected static final Integer PERISHABLE_MAX_QUANTITY = 100;
  protected LocalDate orderDate;
  protected LocalDate expireDate;

  public PerishableFood(String name, Double pricePerUnit, Integer curAvailableQuantity,
      LocalDate orderDate, LocalDate expireDate) {
    super(name, pricePerUnit, curAvailableQuantity);
    this.orderDate = orderDate;
    this.expireDate = expireDate;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public LocalDate getExpireDate() {
    return expireDate;
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof PerishableFood)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    PerishableFood that = (PerishableFood) object;
    return java.util.Objects.equals(getOrderDate(), that.getOrderDate())
        && java.util.Objects.equals(
        getExpireDate(), that.getExpireDate());
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "PerishableFood{" +
        "orderDate=" + orderDate +
        ", expireDate=" + expireDate +
        '}';
  }

  public int hashCode() {
    return java.util.Objects.hash(super.hashCode(), getOrderDate(), getExpireDate());
  }
}
