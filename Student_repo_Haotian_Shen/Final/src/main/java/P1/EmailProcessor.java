package P1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class EmailProcessor provides functionality related to processing of a specific email account.
 * For a given email account, it allows searching and filtering emails by a sender, by a recipients,
 * by subject and by date sent.
 */
public class EmailProcessor {

  private static final Integer RECIPIENTS_CUTOFF = 5;
  private final EmailAccount emailAccount;

  public EmailProcessor(EmailAccount emailAccount) {
    this.emailAccount = emailAccount;
  }

  public EmailAccount getEmailAccount() {
    return emailAccount;
  }

  /**
   * Filter the received emails which are BCCed and have total recipients greater than or equal to 5
   * on the provided date and then save the subjects of these filtered emails into a list of string
   * and return them.
   *
   * @param date - The provided date.
   * @return A list of email subjects by the filtering rules.
   */
  public List<String> mysteryMethod(LocalDate date) {

    return this.emailAccount.getReceivedEmails().stream().filter(Email::getBCCedRecipientsIncluded)
        .filter(y -> y.getRecipients().size() >= RECIPIENTS_CUTOFF)
        .filter(z -> z.getDateSent().equals(date))
        .map(Email::getSubject).collect(Collectors.toList());
  }

  /**
   * Filter the emails which have the provided subject and sent on the provided date.
   *
   * @param subject - The provided subject of emails.
   * @param date    - The date the email was sent.
   * @return A list of emails with the provided subject and sent on the provided date.
   */
  public List<Email> filterSentEmailsBySubjectAndDate(String subject, LocalDate date) {
    return this.emailAccount.getSentEmails().stream()
        .filter(x -> x.getSubject().equals(subject)).filter(y -> y.getDateSent().equals(date))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmailProcessor)) {
      return false;
    }
    EmailProcessor that = (EmailProcessor) o;
    return Objects.equals(getEmailAccount(), that.getEmailAccount());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmailAccount());
  }

  @Override
  public String toString() {
    return "EmailProcessor{" +
        "emailAccount=" + emailAccount +
        '}';
  }
}
