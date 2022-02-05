package p1;

import java.util.Objects;

public class Musician extends Artist {
  private String recordingCompany;
  private String latestAlbum;

  public Musician(Name name, Integer age, String[] genres, String[] awards,
      String recordingCompany, String latestAlbum) throws InvalidAgeException {
    super(name, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.latestAlbum = latestAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public void setRecordingCompany(String recordingCompany) {
    this.recordingCompany = recordingCompany;
  }

  public String getLatestAlbum() {
    return latestAlbum;
  }

  public void setLatestAlbum(String latestAlbum) {
    this.latestAlbum = latestAlbum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Musician)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Musician musician = (Musician) o;
    return getRecordingCompany().equals(musician.getRecordingCompany()) && getLatestAlbum().equals(
        musician.getLatestAlbum());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getRecordingCompany(), getLatestAlbum());
  }

  @Override
  public Artist receiveAward(String award) throws InvalidAgeException {
    return new Musician(this.name, this.age, this.genres, super.updateAwardList(award), this.recordingCompany, this.latestAlbum);
  }
}
