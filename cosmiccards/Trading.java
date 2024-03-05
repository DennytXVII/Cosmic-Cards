package cosmiccards;

import java.util.Random;

public class Trading {
    private Player player;
    private NPC trader;
    private CardLog cardLog;
    private Random random;

    public Trading(Player player, NPC trader, CardLog cardLog) {
        this.player = player;
        this.trader = trader;
        this.cardLog = cardLog;
        this.random = new Random();
    }

    public void executeTrade(Card cardFromPlayer) {
        // Determine the rarity of the card traded by the player
        String playerCardRarity = CardRarity.determineCardRarity(cardFromPlayer);

        // Apply multipliers based on the rarity of the traded card
        double rarityMultiplier = getRarityMultiplier(playerCardRarity);

        Card cardFromTrader = getRandomCardFromTrader(rarityMultiplier);

        // Execute the trade
        initiateTrade(cardFromPlayer, cardFromTrader);
    }

    private Card getRandomCardFromTrader(double rarityMultiplier) {
        double chance = random.nextDouble() * 100; // Random value between 0 and 100

        if (chance < 0.5 * rarityMultiplier) { // 0.5% chance for a Boss Card
            return cardLog.getRandomBossCard();
        } else if (chance < (0.55 + (0.05 * rarityMultiplier))) { // 0.05% chance for a Party Card
            return cardLog.getRandomPartyCard();
        } else {
            return cardLog.getRandomNonBossNonPartyCard();
        }
    }

    private void initiateTrade(Card cardFromPlayer, Card cardFromTrader) {
        // Perform the exchange of cards
        player.removeFromCollection(cardFromPlayer);
        player.addToCollection(cardFromTrader);

        System.out.println("Trade completed. Player received: " + cardFromTrader.getName());
    }

    private double getRarityMultiplier(String rarity) {
        // Define multipliers for each rarity level
        // You can adjust these values as needed
        switch (rarity) {
            case "COMMON":
                return 1.0;
            case "UNCOMMON":
                return 1.2;
            case "RARE":
                return 1.5;
            case "LEGENDARY":
                return 2.0;
            default:
                return 1.0; // Default multiplier
        }
    }
}
