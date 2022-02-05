package rockerPaperScissors;

public class Rock extends GameState {

  public Rock() {

  }

  @Override
  public Boolean winOrLose(GameState opponentState) {
    if (opponentState instanceof Rock) {
      return Boolean.FALSE;
    } else if (opponentState instanceof Paper) {
      return Boolean.FALSE;
    } else {
      return Boolean.TRUE;
    }
  }
}
