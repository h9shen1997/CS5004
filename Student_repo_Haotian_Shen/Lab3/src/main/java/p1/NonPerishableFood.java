package p1;

public abstract class NonPerishableFood extends Food {

  private static final Integer NON_PERISHABLE_MAX_QUANTITY = 250;

  public NonPerishableFood(String name, Double pricePerUnit, Integer curAvailableQuantity) {
    super(name, pricePerUnit, curAvailableQuantity);
  }

}
