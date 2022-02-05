package p1;

import java.util.Arrays;
import java.util.Objects;

public abstract class Artist {
  protected Name name;
  protected Integer age;
  protected String[] genres;
  protected String[] awards;
  private static final Integer MIN_AGE = 0;
  private static final Integer MAX_AGE = 128;

  public Artist(Name name, Integer age, String[] genres, String[] awards)
      throws InvalidAgeException {
    this.name = name;
    if (isValidAge(age)) {
      this.age = age;
    } else {
      throw new InvalidAgeException("The age needs to be between 0 and 128");
    }
    this.genres = genres;
    this.awards = awards;
  }

  private Boolean isValidAge(Integer age) {
    if(age < MIN_AGE || age > MAX_AGE) return false;
    return true;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) throws InvalidAgeException {
    if (isValidAge(age)) {
      this.age = age;
    } else {
      throw new InvalidAgeException("The age needs to be between 0 and 128");
    }
  }

  public String[] getGenres() {
    return genres;
  }

  public void setGenres(String[] genres) {
    this.genres = genres;
  }

  public String[] getAwards() {
    return awards;
  }

  public void setAwards(String[] awards) {
    this.awards = awards;
  }

  protected String[] updateAwardList(String award) throws InvalidAgeException {
    String[] currentAward = Arrays.copyOf(this.awards, this.awards.length + 1);
    currentAward[currentAward.length - 1] = award;
    return currentAward;
  }

  public abstract Artist receiveAward(String award) throws InvalidAgeException;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Artist)) {
      return false;
    }
    Artist artist = (Artist) o;
    return getName().equals(artist.getName()) && getAge().equals(artist.getAge())
        && Arrays.equals(getGenres(), artist.getGenres()) && Arrays.equals(
        getAwards(), artist.getAwards());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getName(), getAge());
    result = 31 * result + Arrays.hashCode(getGenres());
    result = 31 * result + Arrays.hashCode(getAwards());
    return result;
  }

  @Override
  public String toString() {
    return "Artist{" +
        "name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
