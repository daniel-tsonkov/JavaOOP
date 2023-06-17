package CardSuit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Card suits: ");

        CardSuits[] cardSuits = CardSuits.values();

        for (CardSuits card : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card);
        }
    }
}
