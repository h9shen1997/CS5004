package p1;

import java.time.LocalDate;

public class Meat extends PerishableFood {

  public Meat(String name, Double pricePerUnit, Integer curAvailableQuantity,
      LocalDate orderDate, LocalDate expireDate) {
    super(name, pricePerUnit, curAvailableQuantity, orderDate, expireDate);
  }
}
