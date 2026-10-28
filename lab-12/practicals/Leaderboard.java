import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Riya", 95);
        scores.put("Jeel", 88);
        scores.put("Aman", 95);
        scores.put("Priya", 78);
        scores.put("Karan", 88);

        int topN = 3;

        List<Map.Entry<String, Integer>> players =
            new ArrayList<>(scores.entrySet());

        players.sort((a, b) -> {
            int byScore = b.getValue().compareTo(a.getValue());

            if (byScore != 0) {
                return byScore;
            }

            return a.getKey().compareToIgnoreCase(b.getKey());
        });

        System.out.println("Top " + topN + " players:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                player.getKey() + " - " + player.getValue()
            );
        }
    }
}