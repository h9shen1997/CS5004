package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BookTest {

  Book book;

  @Test
  public void getAuthor() {
    book = new Book(new Author(new Name("a", "b")), "illiad", 1998);
    Author a = new Author(new Name("a", "b"));
    assertEquals(a, book.getAuthor());
  }

  @Test
  public void testEqualsSameAddress() {
    book = new Book(new Author(new Name("a", "b")), "illiad", 1998);
    Book b = book;
    assertTrue(b.equals(book) && book.equals(b) && book.hashCode() == b.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    book = new Book(new Author(new Name("a", "b")), "illiad", 1998);
    Book b = new Book(new Author(new Name("a", "b")), "illiad", 1998);
    assertTrue(book.equals(b) && b.equals(book) && b.hashCode() == book.hashCode());
  }

  @Test
  public void isMusic() {
    book = new Book(new Author(new Name("a", "b")), "illiad", 1998);
    assertFalse(book.isMusic());
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    Music music = new Music(ra, "melody", 1998);
    assertTrue(music.isMusic());
  }
}