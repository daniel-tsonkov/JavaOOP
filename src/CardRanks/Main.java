package CardRanks;

public class Main {
    public static void main(String[] args) {
        CardRanksA[] cardRanks = CardRanksA.values();

        System.out.println("Card Ranks:");
        for (CardRanksA cardRank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cardRank.ordinal(), cardRank);
        }
    }
}
