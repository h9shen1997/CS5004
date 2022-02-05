package p1;

import java.util.Arrays;

public abstract class Creator extends Artist {
  protected String[] exhibits;

  public Creator(Name name, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws InvalidAgeException {
    super(name, age, genres, awards);
    this.exhibits = exhibits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Creator)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Creator creator = (Creator) o;
    return Arrays.equals(exhibits, creator.exhibits);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(exhibits);
    return result;
  }

  @Override
  public String toString() {
    return "Creator{" +
        "name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        ", exhibits=" + Arrays.toString(exhibits) +
        '}';
  }
}
