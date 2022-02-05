package p2;

public abstract class Pieces {

  private static final Integer MAXIMUM_AGE = 128;
  protected Name name;
  protected Integer age;

  public Pieces(Name name, Integer age) throws InvalidAgeException {
    if (validateAge(age)) {
      this.name = name;
      this.age = age;
    } else {
      throw new InvalidAgeException("The age is outside of the allowed range!");
    }
  }

  private Boolean validateAge(Integer age) {
    return age >= 0 && age < MAXIMUM_AGE;
  }
}