package p1;

import java.util.Arrays;
import java.util.Objects;

public class Poet extends Artist {
  private String publishingCompany;
  private String lastPublishedCollection;

  public Poet(Name name, Integer age, String[] genres, String[] awards,
      String publishingCompany, String lastPublishedCollection) throws InvalidAgeException {
    super(name, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public void setPublishingCompany(String publishingCompany) {
    this.publishingCompany = publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }

  public void setLastPublishedCollection(String lastPublishedCollection) {
    this.lastPublishedCollection = lastPublishedCollection;
  }

  @Override
  public Artist receiveAward(String award) throws InvalidAgeException {
    return new Poet(this.name, this.age, this.genres, super.updateAwardList(award), this.publishingCompany, this.lastPublishedCollection);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Poet)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Poet poet = (Poet) o;
    return getPublishingCompany().equals(poet.getPublishingCompany())
        && getLastPublishedCollection().equals(poet.getLastPublishedCollection());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPublishingCompany(), getLastPublishedCollection());
  }

  @Override
  public String toString() {
    return "Poet{" +
        "name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        ", publishingCompany='" + publishingCompany + '\'' +
        ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
        '}';
  }
}
