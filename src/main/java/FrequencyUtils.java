import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Computes the frequency of each integer in the given list.
 *
 * @return a map where each key is an integer from the list and each value is its frequency
 */
public class FrequencyUtils {

    /**
     * Returns the frequency of each integer in the given list.
     *
     * @param numbers the input list of integers
     * @return a map of integers to their frequencies
     */
    public static Map<Integer, Double> frequencyCount(List<Integer> numbers) {
        Map<Integer, Double> result = new HashMap<>();

        if (numbers == null || numbers.isEmpty()) {
            return result;
        }

        // Count occurrences
        for (Integer num : numbers) {
            result.put(num, result.getOrDefault(num, 0.0) + 1);
        }

        // Convert counts to frequencies
        int total = numbers.size();
        for (Integer key : result.keySet()) {
            result.put(key, result.get(key) / total);
        }

        return result;
    }
}