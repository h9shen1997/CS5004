package rockerPaperScissors;

public class Paper extends GameState {

  public Paper() {

  }

  @Override
  public Boolean winOrLose(GameState opponentState) {
    if (opponentState instanceof Paper) {
      return Boolean.FALSE;
    } else if (opponentState instanceof Scissor) {
      return Boolean.FALSE;
    } else {
      return Boolean.TRUE;
    }
  }
}
