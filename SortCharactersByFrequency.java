
import java.util.*;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets
        List<Character>[] buckets = new List[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        // Step 3: Build result from highest freq to lowest
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "tree";
        System.out.println(frequencySort(s1)); // eetr or etre

        String s2 = "cccaaa";
        System.out.println(frequencySort(s2)); // cccaaa or aaaccc

        String s3 = "Aabb";
        System.out.println(frequencySort(s3)); // bbAa or bbaA
    }
}
