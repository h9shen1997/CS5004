package problem2;

/**
 * RecordingArtist class inherited from Creator class. It represents a recording artist with name.
 */
public class RecordingArtist extends Creator {

  /**
   * Constructor for recording artist with name.
   *
   * @param name - Name, name.
   */
  public RecordingArtist(Name name) {
    super(name);
  }

  @Override
  protected boolean isAuthor() {
    return false;
  }

  /**
   * Compare whether two RecordingArtist objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RecordingArtist)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate the hashcode for the RecordingArtist object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String expression for the RecordingArtist object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "RecordingArtist{} " + super.toString();
  }
}
