package problem1;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {
  public static Map<String, Long> countTopics(List<String> inputs) {
    Map<String, Long> resultingMap;
    resultingMap = inputs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return resultingMap;
  }

  private static Long countOccurrences(String inputString, List<String> inputs) {
    long counter = 0;
    for(String input : inputs) {
      if(input.equals(inputString)) {
        counter++;
      }
    }
    return counter;
  }

  public static Map<String, Integer> countTopics2(List<String> inputs) {
    Map<String, Long> resultingMap = new HashMap<>();
//    resultingMap = inputs.stream().map();
    return null;
  }
}
