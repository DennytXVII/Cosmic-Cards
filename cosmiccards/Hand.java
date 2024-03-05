// Hand.java
package cosmiccards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private CardJournal cardJournal;

    public Hand(CardJournal cardJournal) {
        cards = new ArrayList<>();
        this.cardJournal = cardJournal;
    }

    public void addCard(int cardId) {
        Card card = cardJournal.getCardById(cardId);
        if (card != null) {
            cards.add(card);
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
