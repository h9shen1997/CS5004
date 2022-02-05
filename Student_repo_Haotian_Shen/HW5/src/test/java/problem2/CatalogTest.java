package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class CatalogTest {

  Catalog catalog;

  @Test
  public void createEmptyCatalog() {
    catalog = new Catalog();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    catalog.addItem(item1);
    catalog.addItem(item2);
    catalog.addItem(item3);
    assertEquals(3, catalog.getCollection().size(), 0);
  }

  @Test
  public void addItem() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Lucas", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    catalog.addItem(item11);
    catalog.addItem(item12);
    catalog.addItem(item13);
    assertEquals(item11, catalog.getCollection().get(10));
    assertEquals(item12, catalog.getCollection().get(11));
    assertEquals(item13, catalog.getCollection().get(12));
    assertEquals(13, catalog.getCollection().size(), 0);
  }

  @Test
  public void removeItem() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Lucas", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Sophia", "b")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    catalog.removeItem(item1);
    catalog.removeItem(item2);
    assertEquals(8, catalog.getCollection().size(), 0);
  }

  @Test
  public void getCollection() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Lucas", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Sophia", "b")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    assertEquals(10, catalog.getCollection().size(), 0);
  }

  @Test
  public void searchWithKeyword() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Lucas", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Sophia", "b")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10, item11, item12,
        item13, item14, item15, item16, item17, item18, item19, item20};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    Set<Item> filteredSet = new HashSet<>();
    filteredSet.add(item1);
    filteredSet.add(item3);
    filteredSet.add(item9);
    List<Item> keywordFilteredList = catalog.search("ar");
    assertEquals(filteredSet, new HashSet<>(keywordFilteredList));
  }

  @Test
  public void searchWithAuthor() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Sophia", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Sophia", "b")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10, item11, item12,
        item13, item14, item15, item16, item17, item18, item19, item20};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    Set<Item> filteredSet = new HashSet<>();
    filteredSet.add(item7);
    filteredSet.add(item19);
    List<Item> keywordFilteredList = catalog.search(new Author(new Name("Sophia", "b")));
    assertEquals(filteredSet, new HashSet<>(keywordFilteredList));
  }

  @Test
  public void searchWithRecordingArtist() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Sophia", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Oliver", "a")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10, item11, item12,
        item13, item14, item15, item16, item17, item18, item19, item20};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    Set<Item> filteredSet = new HashSet<>();
    filteredSet.add(item10);
    filteredSet.add(item11);
    List<Item> keywordFilteredList = catalog.search(new RecordingArtist(new Name("Oliver", "a")));
    assertEquals(filteredSet, new HashSet<>(keywordFilteredList));
  }

  @Test
  public void testEqualsSameAddress() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Sophia", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Oliver", "a")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10, item11, item12,
        item13, item14, item15, item16, item17, item18, item19, item20};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    Catalog catalog1 = catalog;
    assertTrue(catalog.equals(catalog1) && catalog1.equals(catalog)
        && catalog.hashCode() == catalog1.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    List<Item> list = new ArrayList<>();
    Item item1 = new Music(new RecordingArtist(new Name("Liam", "a")), "The best part", 2016);
    Item item2 = new Book(new Author(new Name("Noah", "a")), "All about that bass", 2017);
    Item item3 = new Book(new Author(new Name("Oliver", "a")), "Dear Future husband", 2017);
    Item item4 = new Music(new RecordingArtist(new Name("William", "a")), "Close your Eyes", 2018);
    Item item5 = new Music(new RecordingArtist(new Name("James", "a")), "3am", 2019);
    Item item6 = new Book(new Author(new Name("Lucas", "b")), "Bang Dem Sticks", 2019);
    Item item7 = new Book(new Author(new Name("Sophia", "b")), "Walksshame", 2018);
    Item item8 = new Music(new RecordingArtist(new Name("Noah", "a")), "Title", 2012);
    Item item9 = new Book(new Author(new Name("Alexander", "a")), "lips are moving", 2017);
    Item item10 = new Music(new RecordingArtist(new Name("Oliver", "a")), "give life back to music",
        2017);
    Item item11 = new Music(new RecordingArtist(new Name("Oliver", "a")), "Mountain music", 2021);
    Item item12 = new Book(new Author(new Name("Lucas", "a")), "Don't stop the music", 2018);
    Item item13 = new Book(new Author(new Name("Noah", "a")), "this is country music", 2017);
    Item item14 = new Music(new RecordingArtist(new Name("Chuck", "b")), "Rock and roll Music",
        1957);
    Item item15 = new Book(new Author(new Name("Liam", "a")), "The best music", 2015);
    Item item16 = new Music(new RecordingArtist(new Name("Olivia", "a")), "Dance to the music",
        2000);
    Item item17 = new Book(new Author(new Name("Emma", "b")), "Turn up the book", 2010);
    Item item18 = new Music(new RecordingArtist(new Name("Sophia", "b")), "The sound of music",
        2000);
    Item item19 = new Book(new Author(new Name("Oliver", "a")), "Inception", 2005);
    Item item20 = new Music(new RecordingArtist(new Name("Sophia", "b")), "Dance with me", 2006);
    Item[] itemArray = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9,
        item10, item11, item12,
        item13, item14, item15, item16, item17, item18, item19, item20};
    for (int i = 0; i < itemArray.length; i++) {
      list.add(itemArray[i]);
    }
    catalog = new Catalog(list);
    Catalog catalog1 = new Catalog(list);
    assertTrue(catalog.equals(catalog1) && catalog1.equals(catalog)
        && catalog.hashCode() == catalog1.hashCode());
  }
}