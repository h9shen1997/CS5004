package p1;

import java.util.Arrays;

public abstract class Entertainer extends Artist {
  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  public Entertainer(Name name, Integer age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] otherMultimedia) throws InvalidAgeException {
    super(name, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  public String[] getMovies() {
    return movies;
  }

  public void setMovies(String[] movies) {
    this.movies = movies;
  }

  public String[] getSeries() {
    return series;
  }

  public void setSeries(String[] series) {
    this.series = series;
  }

  public String[] getOtherMultimedia() {
    return otherMultimedia;
  }

  public void setOtherMultimedia(String[] otherMultimedia) {
    this.otherMultimedia = otherMultimedia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Entertainer)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Entertainer that = (Entertainer) o;
    return Arrays.equals(getMovies(), that.getMovies()) && Arrays.equals(
        getSeries(), that.getSeries()) && Arrays.equals(getOtherMultimedia(),
        that.getOtherMultimedia());
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(getMovies());
    result = 31 * result + Arrays.hashCode(getSeries());
    result = 31 * result + Arrays.hashCode(getOtherMultimedia());
    return result;
  }

  @Override
  public String toString() {
    return "Entertainer{" +
        "name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        ", movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
        '}';
  }
}
