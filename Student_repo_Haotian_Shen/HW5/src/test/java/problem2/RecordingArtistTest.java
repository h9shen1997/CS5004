package problem2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecordingArtistTest {

  @Test
  public void testEqualsSubtypeAndParent() {
    RecordingArtist ra1 = new RecordingArtist(new Name("a", "b"));
    Creator ra2 = new RecordingArtist(new Name("a", "b"));
    assertTrue(ra1.equals(ra2) && ra2.equals(ra1) && ra1.hashCode() == ra2.hashCode());
  }

  @Test
  public void testEqualsSameAddress() {
    RecordingArtist ra1 = new RecordingArtist(new Name("a", "b"));
    RecordingArtist ra2 = ra1;
    assertTrue(ra1.equals(ra2) && ra2.equals(ra1) && ra1.hashCode() == ra2.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    RecordingArtist ra1 = new RecordingArtist(new Name("a", "b"));
    RecordingArtist ra2 = new RecordingArtist(new Name("a", "b"));
    assertTrue(ra1.equals(ra2) && ra2.equals(ra1) && ra1.hashCode() == ra2.hashCode());
  }

  @Test
  public void testEqualsAuthorAndRecordingArtist() {
    Author author = new Author(new Name("a", "b"));
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    assertFalse(author.equals(ra) || ra.equals(author));
  }
}