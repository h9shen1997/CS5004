package problem2;

import java.util.Objects;

/**
 * Music class inherited from Item class. It represents a music with either an individual recording
 * artist or a band with multiple recording artists.
 */
public class Music extends Item {

  private RecordingArtist recordingArtist;
  private Band band;

  /**
   * Constructor that creates a Music object with a single recording artist, title, and the year of
   * release.
   *
   * @param recordingArtist - RecordingArtist, single recording artist.
   * @param title           - String, the title.
   * @param yearReleased    - Integer, the year of release.
   */
  public Music(RecordingArtist recordingArtist, String title, Integer yearReleased) {
    super(title, yearReleased);
    this.recordingArtist = recordingArtist;
  }

  /**
   * Constructor that creates a Music object with a band, title, and the year of release.
   *
   * @param band         - Band, the band.
   * @param title        - String, the title.
   * @param yearReleased - Integer, the year of release.
   */
  public Music(Band band, String title, Integer yearReleased) {
    super(title, yearReleased);
    this.band = band;
  }

  /**
   * Getter for the band.
   *
   * @return - Band, the band or null if the music is created by a single artist.
   */
  public Band getBand() {
    return this.band;
  }

  /**
   * Getter for the recording artist.
   *
   * @return - RecordingArtist, the recording artist or null if the music is created by a band.
   */
  public RecordingArtist getRecordingArtist() {
    return this.recordingArtist;
  }

  /**
   * Determine if the Music is created by a band or not.
   *
   * @return - boolean, is band or not.
   */
  public boolean isBand() {
    return this.recordingArtist == null;
  }

  /**
   * Compare whether two Music objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Music)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Music music = (Music) o;
    return Objects.equals(getRecordingArtist(), music.getRecordingArtist())
        && Objects.equals(isBand(), music.isBand());
  }

  @Override
  protected boolean isMusic() {
    return true;
  }

  /**
   * Generate the hashcode for the Music object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getRecordingArtist(), isBand());
  }

  /**
   * String expression of Music object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Music{" +
        "recordingArtist=" + recordingArtist +
        ", band=" + band +
        "} " + super.toString();
  }
}
