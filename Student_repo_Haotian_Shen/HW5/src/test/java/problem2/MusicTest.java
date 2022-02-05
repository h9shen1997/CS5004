package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class MusicTest {

  Music music;

  @Test
  public void getBandWhenTheCreatorIsNotBand() {
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    music = new Music(ra, "melody", 1998);
    assertNull(music.getBand());
  }

  @Test
  public void getBandWhenTheCreatorIsBand() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    music = new Music(band, "melody", 1998);
    assertEquals(music.getBand().getMembers().size(), 3, 0);
  }

  @Test
  public void getRecordingArtistWhenTheCreatorIsRecordingArtist() {
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    music = new Music(ra, "melody", 1998);
    RecordingArtist raCopy = new RecordingArtist(new Name("a", "b"));
    assertEquals(raCopy, music.getRecordingArtist());
  }

  @Test
  public void getRecordingArtistWhenTheCreatorIsNotRecordingArtist() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    music = new Music(band, "melody", 1998);
    assertNull(music.getRecordingArtist());
  }

  @Test
  public void isBand() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    music = new Music(band, "melody", 1998);
    assertTrue(music.isBand());
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    music = new Music(ra, "melody", 1998);
    assertFalse(music.isBand());
  }

  @Test
  public void testEqualsSameAddress() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    music = new Music(band, "melody", 1998);
    Music m = music;
    assertTrue(music.equals(m) && m.equals(music) && m.hashCode() == music.hashCode());
  }

  @Test
  public void testEqualSameContent() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    music = new Music(band, "melody", 1998);
    Music m = new Music(band, "melody", 1998);
    assertTrue(music.equals(m) && m.equals(music) && m.hashCode() == music.hashCode());
  }

  @Test
  public void isMusic() {
    Book book = new Book(new Author(new Name("a", "b")), "illiad", 1998);
    assertFalse(book.isMusic());
    RecordingArtist ra = new RecordingArtist(new Name("a", "b"));
    music = new Music(ra, "melody", 1998);
    assertTrue(music.isMusic());
  }
}