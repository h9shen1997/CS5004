package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

  public static Map<Integer, Double> getFrequencyCount(List<Integer> listOfInts) {
    Map<Integer, Double> map = new HashMap<>();
    for (int i = 0; i < listOfInts.size(); i++) {
      map.put(listOfInts.get(i),
          map.getOrDefault(listOfInts.get(i), 0.0) + 1.0 / listOfInts.size());
    }
    return map;
  }
}
