package problem3;

import java.util.*;
import problem2.Swimmer;

public class SwimmerIterator implements Iterator<Swimmer> {

  private List<Swimmer> qualifyingSwimmers = new ArrayList<>();

  public SwimmerIterator(List<Swimmer> qualifyingSwimmers) {
    this.qualifyingSwimmers = this.getQualifiedSwimmers(qualifyingSwimmers);
  }

  private List<Swimmer> getQualifiedSwimmers(List<Swimmer> qualifyingSwimmers) {
    List<Swimmer> res = new ArrayList<>();
    for(Swimmer swimmer : qualifyingSwimmers) {
      if(swimmer.hasEnoughButterflyRaces() && swimmer.isQualified()) {
        res.add(swimmer);
      }
    }
    return res;
  }

  @Override
  public boolean hasNext() {
    return this.qualifyingSwimmers.size() > 0;
  }

  @Override
  public Swimmer next() {
    Swimmer swimmer = this.qualifyingSwimmers.get(0);
    this.qualifyingSwimmers.remove(0);
    return swimmer;
  }
}
