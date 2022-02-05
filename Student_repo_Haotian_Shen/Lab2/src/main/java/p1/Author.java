package p1;

/**
 * Class author stores information about an author.
 */
public class Author {

  private String name;
  private String email;
  private String address;

  /**
   * Constructor that creates an new Author object with the specified name, email and address.
   *
   * @param name    - String, representing author's name.
   * @param email   - String, representing author's email.
   * @param address - String, representing author's address.
   */
  public Author(String name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }

  /**
   * Getter for name.
   *
   * @return String, the author's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name.
   *
   * @param name - String, new author's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for email.
   *
   * @return String, the author's email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setter for email.
   *
   * @param email - String, new author's email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Getter for address.
   *
   * @return String, the author's address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Setter for address.
   *
   * @param address - String, new author's address.
   */
  public void setAddress(String address) {
    this.address = address;
  }
}
