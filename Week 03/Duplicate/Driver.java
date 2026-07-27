public class Driver {

    public static void main(String[] args) {

        Card[] cards = {
                new Card("Ace", "Spades"),
                new Card("Queen", "Hearts"),
                new Card("King", "Clubs"),
                new Card("Ace", "Spades")
        };

        for (int i = 0; i < cards.length; i++) {

            for (int j = 0; j < i; j++) {

                if (cards[i].equals(cards[j])) {
                    System.out.println("Duplicate found: " + cards[i]);
                    return;
                }
            }
        }
    }

    static class Card {
        private final String rank;
        private final String suit;

        Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Card)) {
                return false;
            }
            Card other = (Card) obj;
            return rank.equals(other.rank) && suit.equals(other.suit);
        }

        @Override
        public int hashCode() {
            return rank.hashCode() * 31 + suit.hashCode();
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }
}
