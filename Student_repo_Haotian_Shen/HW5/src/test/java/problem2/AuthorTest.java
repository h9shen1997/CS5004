package problem2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AuthorTest {

  @Test
  public void testEqualsSubtypeAndParent() {
    Author author1 = new Author(new Name("a", "b"));
    Creator author2 = new Author(new Name("a", "b"));
    assertTrue(author1.equals(author2) && author2.equals(author1)
        && author1.hashCode() == author2.hashCode());
  }

  @Test
  public void testEqualsSameAddress() {
    Author author1 = new Author(new Name("a", "b"));
    Author author2 = author1;
    assertTrue(author1.equals(author2) && author2.equals(author1)
        && author1.hashCode() == author2.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    Author author1 = new Author(new Name("a", "b"));
    Author author2 = new Author(new Name("a", "b"));
    assertTrue(author1.equals(author2) && author2.equals(author1)
        && author1.hashCode() == author2.hashCode());
  }

  @Test
  public void testEqualsAuthorAndRecordingArtist() {
    Author author = new Author(new Name("a", "b"));
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    assertFalse(author.equals(ra) || ra.equals(author));
  }
}