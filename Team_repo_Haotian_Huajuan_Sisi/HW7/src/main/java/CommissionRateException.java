/**
 * CommissionRateException is used when the commission rate of the agent is not between 0 and 1,
 * inclusive.
 */
public class CommissionRateException extends Exception {

  public CommissionRateException(String message) {
    super(message);
  }
}
