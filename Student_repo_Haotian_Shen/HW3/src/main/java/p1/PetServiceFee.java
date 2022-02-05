package p1;

/**
 * Interface that defines the behavior of pets service fee based on the number of pets within the
 * property.
 */
public interface PetServiceFee {

  Double LESS_THAN_THREE_FEE = 0.05;
  Double GREATER_THAN_TWO_FEE = 0.07;
  Integer ONE_PET = 1;
  Integer TWO_PET = 2;
  Integer THREE_PET = 3;

  /**
   * Calculate the pets surcharge percentage based on the pets number.
   *
   * @return - Double, the pets fee surcharge.
   */
  Double calculatePetFee();
}
