package cosmiccards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final int MAXIMUM_CARDS = 30;
    private static final int HAND_SIZE = 5;

    private List<Card> cards;

    public Deck(String deckName, List<Card> cards) {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (cards.size() < MAXIMUM_CARDS) {
            cards.add(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> drawCards(int numCards) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            if (!cards.isEmpty()) {
                drawnCards.add(cards.remove(0));
            }
        }
        return drawnCards;
    }

    public boolean refillHand(List<Card> hand) {
        if (hand.size() < HAND_SIZE) {
            int cardsNeeded = HAND_SIZE - hand.size();
            List<Card> drawnCards = drawCards(cardsNeeded);
            hand.addAll(drawnCards);
            return true;
        }
        return false;
    }

    public int size() {
        return cards.size();
    }

    public boolean isValid() {
        return cards.size() == MAXIMUM_CARDS;
    }

    public int getName() {
    }
}
