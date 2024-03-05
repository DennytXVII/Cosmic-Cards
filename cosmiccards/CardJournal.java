package cosmiccards;

import java.util.ArrayList;
import java.util.List;

public class CardJournal {
    private List<Card> commonCards;
    private List<Card> bossCards;
    private List<Card> partyCards;
    private List<Card> specialtyCards;
    private List<Card> uniqueCards;
    private List<Deck> decks;
    private boolean journalOfEnemyCardsUnlocked;

    public CardJournal() {
        commonCards = new ArrayList<>();
        bossCards = new ArrayList<>();
        partyCards = new ArrayList<>();
        specialtyCards = new ArrayList<>();
        uniqueCards = new ArrayList<>();
        decks = new ArrayList<>();
        journalOfEnemyCardsUnlocked = false;
    }

    public void addCommonCard(Card card) {
        commonCards.add(card);
    }

    public void addBossCard(Card card) {
        bossCards.add(card);
    }

    public void addPartyCard(Card card) {
        partyCards.add(card);
    }

    public void addSpecialtyCard(Card card) {
        specialtyCards.add(card);
    }

    public void addUniqueCard(Card card) {
        uniqueCards.add(card);
    }

    public void unlockJournalOfEnemyCards() {
        journalOfEnemyCardsUnlocked = true;
    }

    public boolean isJournalOfEnemyCardsUnlocked() {
        return journalOfEnemyCardsUnlocked;
    }

    public List<Card> getEnemyCardsList() {
        List<Card> enemyCardsList = new ArrayList<>();
        // Add enemy cards to the list from wherever they are stored
        return enemyCardsList;
    }

    public void displayCardDetails(Card card) {
        System.out.println("Card Name: " + card.getName());
        System.out.println("Element: " + card.getCardElement());
        System.out.println("AVCCID: " + card.getAVCCID());
        // You can include more details as needed
    }

    public void createDeck(String deckName, List<Card> cards) {
        int totalCards = cards.size();

        // Check if the deck contains exactly 30 cards
        if (totalCards != 30) {
            System.out.println("Deck creation failed. The deck must contain exactly 30 cards.");
            return;
        }

        int partyCardCount = 0;
        int bossCardCount = 0;

        // Check the types of cards in the deck
        for (Card card : cards) {
            if (card.getType().equals("Party")) {
                partyCardCount++;
            } else if (card.getType().equals("Boss")) {
                bossCardCount++;
            }
        }

        if (partyCardCount > 1) {
            System.out.println("Deck creation failed. Only one party card is allowed.");
            return;
        }

        if (bossCardCount > 4) {
            System.out.println("Deck creation failed. Maximum of four boss cards are allowed.");
            return;
        }

        // If all restrictions are met, create the deck
        Deck deck = new Deck(deckName, cards);
        decks.add(deck);
        System.out.println("Deck \"" + deckName + "\" created successfully.");
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void displayDecks() {
        if (decks.isEmpty()) {
            System.out.println("No decks available.");
            return;
        }
        System.out.println("Available Decks:");
        for (int i = 0; i < decks.size(); i++) {
            System.out.println((i + 1) + ". " + decks.get(i).getName());
        }
    }

    public Deck getDeck(int index) {
        if (index >= 0 && index < decks.size()) {
            return decks.get(index);
        }
        return null;
    }

    public List<String> getAllCards() {
        return null;
    }
}
