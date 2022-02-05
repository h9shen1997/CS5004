package rockerPaperScissors;

public class Scissor extends GameState {

  public Scissor() {

  }

  @Override
  public Boolean winOrLose(GameState opponentState) {
    if (opponentState instanceof Scissor) {
      return Boolean.FALSE;
    } else if (opponentState instanceof Rock) {
      return Boolean.FALSE;
    } else {
      return Boolean.TRUE;
    }
  }
}
