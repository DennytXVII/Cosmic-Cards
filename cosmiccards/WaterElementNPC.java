package cosmiccards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterElementNPC extends NPC {
    private Random random;
    private CardLog cardLog;

    public WaterElementNPC(String name, cardLog cardLog) {
        super(name);
        this.cardLog = cardLog;
        this.random = new Random();
    }

    @Override
    public void chooseInitialCards() {
        List<Card> waterCards = cardLog.getWaterElementCards();
        List<Card> selectedCards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Card randomCard;
            double chance = random.nextDouble() * 100; // Random value between 0 and 100
            if (chance < 0.1) { // 0.1% chance for a Boss Card
                randomCard = cardLog.getRandomBossCard();
            } else if (chance < 0.5) { // 0.4% chance for a Player Card
                randomCard = cardLog.getRandomPlayerCard();
            } else {
                randomCard = getRandomCardWithRarity(waterCards);
            }
            selectedCards.add(randomCard);
        }
        setHand(selectedCards);
    }

    private void setHand(List<Card> selectedCards) {

    }

    private Card getRandomCardWithRarity(List<Card> cards) {
        String rarity = CardRarity.determineCardRarity();
        List<Card> cardsWithRarity = cardLog.getCardsWithRarity(cards, rarity);
        return cardsWithRarity.get(random.nextInt(cardsWithRarity.size()));
    }
}
