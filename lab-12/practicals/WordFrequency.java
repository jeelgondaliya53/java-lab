import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "Java is easy and Java is powerful";
        String[] words = paragraph.toLowerCase().split("\\W+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> {
            int byFrequency = b.getValue().compareTo(a.getValue());
            if (byFrequency != 0) {
                return byFrequency;
            }
            return a.getKey().compareTo(b.getKey());
        });

        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + " : " + entry.getValue()
            );
        }
    }
}