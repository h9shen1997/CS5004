package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class BandTest {

  @Test
  public void createBandUsingMember() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    assertEquals(3, band.getMembers().size(), 0);
  }

  @Test
  public void addBandMemberRecordingArtist() throws IllegalArgumentException {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    Creator ra4 = new RecordingArtist(new Name("o", "p"));
    Creator ra5 = new RecordingArtist(new Name("r", "s"));
    band.addBandMember(ra4);
    band.addBandMember(ra5);
    assertEquals(5, band.getMembers().size(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addBandMemberAuthor() throws IllegalArgumentException {
    Set<Creator> set = new HashSet<>();
    Creator a1 = new Author(new Name("a", "b"));
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    band.addBandMember(a1);
  }

  @Test
  public void removeBandMemberRecordingArtist() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    band.removeBandMember((ra2));
    assertEquals(2, band.getMembers().size(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeBandMemberAuthor() {
    Set<Creator> set = new HashSet<>();
    Creator a1 = new Author(new Name("a", "b"));
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    band.removeBandMember(a1);
  }

  @Test
  public void getBandName() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    assertEquals("a", band.getBandName());
  }

  @Test
  public void getMembers() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    Set<Creator> testSet = band.getMembers();
    assertTrue(set.equals(testSet));
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
    Band bandCopy = band;
    assertTrue(
        band.equals(bandCopy) && bandCopy.equals(band) && band.hashCode() == bandCopy.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    Set<Creator> set = new HashSet<>();
    RecordingArtist ra1 = new RecordingArtist(new Name("g", "h"));
    RecordingArtist ra2 = new RecordingArtist(new Name("i", "j"));
    Creator ra3 = new RecordingArtist(new Name("l", "m"));
    set.add(ra1);
    set.add(ra2);
    set.add(ra3);
    Band band = new Band("a", set);
    Band bandCopy = new Band("a", set);
    assertTrue(
        band.equals(bandCopy) && bandCopy.equals(band) && band.hashCode() == bandCopy.hashCode());
  }
}