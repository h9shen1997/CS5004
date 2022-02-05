package p1;

import java.time.LocalDate;

public class Vegetable extends PerishableFood {

  public Vegetable(String name, Double pricePerUnit, Integer curAvailableQuantity,
      LocalDate orderDate, LocalDate expireDate) {
    super(name, pricePerUnit, curAvailableQuantity, orderDate, expireDate);
  }
}
