package P1;

import static org.junit.Assert.assertEquals;

import CommonClasses.Name;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class EmailProcessorTest {


  EmailProcessor ep;

  @Test
  public void mysteryMethod() {
    Name name = new Name("James", "E", "Kok");
    List<String> recipientMoreThanAndEqualToFive = Arrays.asList("Frank", "James", "Jack", "Fred",
        "Paul", "Jason");
    List<String> recipientLessThanFive = Arrays.asList("Frank", "James", "Jason");
    Email email1 = new Email("Frank", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), true, "Shopping",
        LocalDate.of(2021, 5, 15));
    Email email2 = new Email("James", new ArrayList<>(recipientLessThanFive),
        new ArrayList<>(recipientLessThanFive), false, "Driving",
        LocalDate.of(2021, 5, 14));
    Email email3 = new Email("Jack", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), true, "Training",
        LocalDate.of(2021, 5, 15));
    Email email4 = new Email("Fred", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), false, "Important Announcement",
        LocalDate.of(2021, 5, 15));
    Email email5 = new Email("Jason", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), true, "Skiing",
        LocalDate.of(2021, 4, 18));
    EmailAccount account = new EmailAccount(name, "james.kwok@northeastern.edu",
        Arrays.asList(email1, email2, email3, email4, email5), new ArrayList<>());
    ep = new EmailProcessor(account);
    List<String> test = Arrays.asList("Shopping", "Training");
    assertEquals(test, ep.mysteryMethod(LocalDate.of(2021, 5, 15)));
  }

  @Test
  public void filterSentEmailsBySubjectAndDate() {
    Name name = new Name("James", "E", "Kok");
    List<String> recipientMoreThanAndEqualToFive = Arrays.asList("Frank", "James", "Jack", "Fred",
        "Paul", "Jason");
    List<String> recipientLessThanFive = Arrays.asList("Frank", "James", "Jason");
    Email email1 = new Email("Frank", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), true, "Shopping",
        LocalDate.of(2021, 5, 15));
    Email email2 = new Email("James", new ArrayList<>(recipientLessThanFive),
        new ArrayList<>(recipientLessThanFive), false, "Driving",
        LocalDate.of(2021, 5, 14));
    Email email3 = new Email("Jack", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), true, "Training",
        LocalDate.of(2021, 5, 15));
    Email email4 = new Email("Fred", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), false, "Important Announcement",
        LocalDate.of(2021, 5, 15));
    Email email5 = new Email("Jason", new ArrayList<>(recipientMoreThanAndEqualToFive),
        new ArrayList<>(recipientMoreThanAndEqualToFive), true, "Shopping",
        LocalDate.of(2021, 5, 15));
    EmailAccount account = new EmailAccount(name, "james.kwok@northeastern.edu",
        new ArrayList<>(), Arrays.asList(email1, email2, email3, email4, email5));
    ep = new EmailProcessor(account);
    List<Email> test = Arrays.asList(email1, email5);
    assertEquals(test, ep.filterSentEmailsBySubjectAndDate("Shopping", LocalDate.of(2021, 5, 15)));
  }
}