package p1;

public class Dancer extends Entertainer {

  public Dancer(Name name, Integer age, String[] genres, String[] awards, String[] movies,
      String[] series, String[] otherMultimedia) throws InvalidAgeException {
    super(name, age, genres, awards, movies, series, otherMultimedia);
  }

  @Override
  public Artist receiveAward(String award) throws InvalidAgeException {
    return new Dancer(this.name, this.age, this.genres, super.updateAwardList(award), this.movies, this.series, this.otherMultimedia);
  }
}
