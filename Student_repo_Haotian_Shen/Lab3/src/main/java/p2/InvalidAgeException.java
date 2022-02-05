package p2;

public class InvalidAgeException extends Exception {

  public InvalidAgeException() {
  }

  public InvalidAgeException(String errMessage) {
    super(errMessage);
  }
}