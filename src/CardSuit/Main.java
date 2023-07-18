package CardSuit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Card Suits:");

        CardSuitsA[] cardSuits = CardSuitsA.values();

        for (CardSuitsA card : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card);
        }


    }
}
