import java.util.Random;
import java.util.Scanner;


public class RPSLS {

    enum Move {
        ROCK,
        PAPER,
        SCISSORS,
        LIZARD,
        SPOCK
    }

    public static int winner(Move player, Move computer) {

        if (player == computer) {
            return 0;
        }

        if (player == Move.ROCK) {
            if (computer == Move.SCISSORS || computer == Move.LIZARD)
                return 1;
            else
                return -1;
        }

        if (player == Move.PAPER) {
            if (computer == Move.ROCK || computer == Move.SPOCK)
                return 1;
            else
                return -1;
        }

        if (player == Move.SCISSORS) {
            if (computer == Move.PAPER || computer == Move.LIZARD)
                return 1;
            else
                return -1;
        }

        if (player == Move.LIZARD) {
            if (computer == Move.PAPER || computer == Move.SPOCK)
                return 1;
            else
                return -1;
        }

        if (player == Move.SPOCK) {
            if (computer == Move.ROCK || computer == Move.SCISSORS)
                return 1;
            else
                return -1;
        }

        return 0;
    }

    public static void main(String[] args) {

        Random random = new Random();

        try (Scanner sc = new Scanner(System.in)) {
            int playerScore = 0;
            int computerScore = 0;

            for (int round = 1; round <= 5; round++) {

                System.out.println("\nRound " + round);

                System.out.print("Enter Move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");

                String input = sc.next().toUpperCase();

                Move player = Move.valueOf(input);

                Move[] moves = Move.values();
                Move computer = moves[random.nextInt(moves.length)];

                System.out.println("Computer Move: " + computer);

                int result = winner(player, computer);

                switch (result) {
                    case 1 -> {
                        System.out.println("Player Wins This Round");
                        playerScore++;
                    }
                    case -1 -> {
                        System.out.println("Computer Wins This Round");
                        computerScore++;
                    }
                    default -> System.out.println("Round Draw");
                }
            }

            System.out.println("\n===== FINAL RESULT =====");
            System.out.println("Player Score   : " + playerScore);
            System.out.println("Computer Score : " + computerScore);

            if (playerScore > computerScore) {
                System.out.println("Overall Winner : Player");
            } else if (computerScore > playerScore) {
                System.out.println("Overall Winner : Computer");
            } else {
                System.out.println("Match Draw");
            }
        }
    }
}

