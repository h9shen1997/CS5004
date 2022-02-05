package p1;

public class Painter extends Creator {

  public Painter(Name name, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws InvalidAgeException {
    super(name, age, genres, awards, exhibits);
  }

  @Override
  public Artist receiveAward(String award) throws InvalidAgeException {
    return new Painter(this.name, this.age, this.genres, super.updateAwardList(award), this.exhibits);
  }
}
