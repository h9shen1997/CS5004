package p1;

import java.time.LocalDate;

public class Fruit extends PerishableFood {

  public Fruit(String name, Double pricePerUnit, Integer curAvailableQuantity,
      LocalDate orderDate, LocalDate expireDate) {
    super(name, pricePerUnit, curAvailableQuantity, orderDate, expireDate);
  }
}
