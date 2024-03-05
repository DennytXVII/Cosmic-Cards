package cosmiccards;

import java.util.Random;

public class CardRarity {
    // Define thresholds for rarity percentages
    private static final double COMMON_THRESHOLD = 70.0;
    private static final double UNCOMMON_THRESHOLD = COMMON_THRESHOLD + 24.0;
    private static final double RARE_THRESHOLD = UNCOMMON_THRESHOLD + 5.9;
    private static final double LEGENDARY_THRESHOLD = RARE_THRESHOLD + 0.1;

    private static final Random random = new Random();

    // Method to determine the rarity of a card
    public static String determineCardRarity() {
        double chance = random.nextDouble() * 100; // Random value between 0 and 100

        if (chance < COMMON_THRESHOLD) {
            return "COMMON";
        } else if (chance < UNCOMMON_THRESHOLD) {
            return "UNCOMMON";
        } else if (chance < RARE_THRESHOLD) {
            return "RARE";
        } else if (chance < LEGENDARY_THRESHOLD) {
            return "LEGENDARY";
        } else {
            // Default to common if chance exceeds legendary threshold
            return "COMMON";
        }
    }

    public static String determineCardRarity(Card cardFromPlayer) {
    }
}
