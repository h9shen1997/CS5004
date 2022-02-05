package problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreatorTest {

  @Test
  public void getName() {
    Creator author = new Author(new Name("a", "b"));
    Name testName = new Name("a", "b");
    assertEquals(testName, author.getName());
  }
}