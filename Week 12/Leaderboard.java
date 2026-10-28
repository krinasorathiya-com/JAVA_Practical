import java.util.*;

public class Leaderboard {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Krina", 92);
        scores.put("Riya", 85);
        scores.put("Aarav", 92);
        scores.put("Neha", 78);
        scores.put("Dev", 88);
        scores.put("Meera", 85);

        List<Map.Entry<String, Integer>> players =
            new ArrayList<>(scores.entrySet());

        players.sort((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> {

            int scoreCompare =
                    b.getValue().compareTo(a.getValue());
            
            if (scoreCompare != 0) {
                return scoreCompare;
            }
            
            return a.getKey().compareTo(b.getKey());
        });

        int topN = 3;

        System.out.println("Top " + topN + " Players:");

        for (int i = 0; i < topN && i < players.size(); i++) {

            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                (i + 1) + ". " +
                player.getKey() + " - " +
                player.getValue()
            );
        }
    }
}