package cosmiccards;
import java.util.Map;
import java.util.Random;

public class EnemyRewardsHandler {
    private CardJournal journal;
    private Map<String, Integer> enemyToAVCCIDMap;
    private Map<Integer, Double> cardAcquisitionPercentages; // Map from AVCCID to acquisition percentage

    public EnemyRewardsHandler(CardJournal journal) {
        this.journal = journal;
        initializeEnemyToAVCCIDMap();
        initializeCardAcquisitionPercentages();
    }

    private void initializeEnemyToAVCCIDMap() {
        // Your existing code here...
    }

    private void initializeCardAcquisitionPercentages() {
        // Populate card acquisition percentages from the Card Logger
        // Example:
        cardAcquisitionPercentages = CardLog.getCardAcquisitionPercentages();
    }

    private boolean shouldAcquireCard(String enemyName) {
        Integer AVCCID = enemyToAVCCIDMap.get(enemyName);
        if (AVCCID != null && cardAcquisitionPercentages.containsKey(AVCCID)) {
            double acquisitionPercentage = cardAcquisitionPercentages.get(AVCCID);
            Random rand = new Random();
            double chance = rand.nextDouble() * 100; // Random value between 0 and 100
            return chance < acquisitionPercentage; // Check if chance is within acquisition percentage
        }
        return false; // Return false if no AVCCID found or acquisition percentage not available
    }

    public void handleEnemyRewards(String enemyName) {
        if (shouldAcquireCard(enemyName)) {
            // Handle acquiring the card
            System.out.println("Congratulations! You acquired the card from " + enemyName);
            String rarity = CardRarity.determineCardRarity();
            System.out.println("Rarity: " + rarity);
        } else {
            // Handle cases where the player does not acquire the card
            System.out.println("You defeated " + enemyName + ", but it did not drop a card this time.");
        }
    }
}
