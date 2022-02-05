/**
 * ListingNotFoundException is used when the listing is not found in the agent's collection.
 */
public class ListingNotFoundException extends Exception {

  public ListingNotFoundException(String message) {
    super(message);
  }
}
