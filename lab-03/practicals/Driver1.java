
public class Driver1 {
    public static void main(String[] args) {

        Card[] cards = new Card[5];

        Card[] input = {
                new Card("King", "Hearts"),
                new Card("Ace", "Spades"),
                new Card("Ace", "Spades"),
                new Card("King", "Hearts"),
                new Card("Queen", "Diamonds"),


                
        };

        boolean dup= false;
        int size = 0;

        for (int i = 0; i < input.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < size; j++) {
                if (input[i].equals(cards[j])) {
                    duplicate=true;

                    if (!dup) {
                        System.out.println("Duplicate found: " + input[i]);
                        dup=true;
                    }

                    break;
                }
            }

            cards[size] = input[i];
            size++;
        }
    }
}
    

