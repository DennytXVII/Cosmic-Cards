package cosmiccards;

import java.util.ArrayList;
import java.util.List;

public class JournalSearch extends CardJournal {
    public JournalSearch(List<Card> cards) {
        super(cards);
    }

    public List<Card> searchByName(String name) {
        List<Card> results = new ArrayList<>();
        for (Card card : getCards()) {
            if (card.getName().equalsIgnoreCase(name)) {
                results.add(card);
            }
        }
        return results;
    }

    private Card[] getCards() {
        return new Card[0];
    }

    public List<Card> searchByElement(String element) {
        List<Card> results = new ArrayList<>();
        for (Card card : getCards()) {
            if (card.getCardElement().equalsIgnoreCase(element)) {
                results.add(card);
            }
        }
        return results;
    }

    public List<Card> searchByAVCCID(String avccid) {
        List<Card> results = new ArrayList<>();
        for (Card card : getCards()) {
            if (card.getAVCCID().equalsIgnoreCase(avccid)) {
                results.add(card);
            }
        }
        return results;
    }

    // Add more search methods as needed

    // Example usage:
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        // Populate cards list with data
        JournalSearch journalSearch = new JournalSearch(cards);

        // Search by name
        List<Card> nameResults = journalSearch.searchByName("Dart Feld");
        System.out.println("Search results by name:");
        for (Card card : nameResults) {
            System.out.println(card.getName());
        }

        // Search by element
        List<Card> elementResults = journalSearch.searchByElement("Fire");
        System.out.println("Search results by element:");
        for (Card card : elementResults) {
            System.out.println(card.getName());
        }

        // Search by AVCCID
        List<Card> avccidResults = journalSearch.searchByAVCCID("A647");
        System.out.println("Search results by AVCCID:");
        for (Card card : avccidResults) {
            System.out.println(card.getName());
        }
    }
}
