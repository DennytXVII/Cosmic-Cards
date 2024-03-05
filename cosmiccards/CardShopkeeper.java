package cosmiccards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardShopkeeper {
    private Player player;
    private List<Card> inventory;
    private Random random;

    public CardShopkeeper(Player player) {
        this.player = player;
        this.inventory = new ArrayList<>();
        this.random = new Random();
        refreshInventory();
    }

    public void interact() {
        System.out.println("Hello, how can I help you today?");
        System.out.println("1. Buy cards");
        System.out.println("2. Sell cards");
        System.out.println("3. Cancel");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                buyCards();
                break;
            case 2:
                sellCards();
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void buyCards() {
        System.out.println("Here are the available cards for purchase:");
        displayShopStock();

        int cardIndex = getPlayerChoice("Select a card to buy: ", 1, inventory.size()) - 1;
        Card selectedCard = inventory.get(cardIndex);

        int price = calculateCardPrice(selectedCard);
        String rarity = CardRarity.determineCardRarity(); // Determine rarity of the acquired card

        if (player.getCurrency() >= price) {
            player.subtractCurrency(price);
            player.addToCollection(selectedCard);
            System.out.println("You bought " + selectedCard.getName() + " for " + price + " currency. Rarity: " + rarity);
        } else {
            System.out.println("You don't have enough currency to buy this card.");
        }
    }

    private void sellCards() {
        System.out.println("Here are the cards you can sell:");
        player.displayCollection();

        int cardIndex = getPlayerChoice("Select a card to sell: ", 1, player.getCollectionSize()) - 1;
        Card selectedCard = player.getCardFromCollection(cardIndex);

        int price = calculateSellPrice(selectedCard);

        player.removeFromCollection(selectedCard);
        player.addCurrency(price);

        System.out.println("You sold " + selectedCard.getName() + " for " + price + " currency.");
    }

    private int calculateCardPrice(Card card) {
        return random.nextInt(100);
    }

    private int calculateSellPrice(Card card) {
        // Get the rarity multiplier based on the card's rarity
        double rarityMultiplier = getRarityMultiplier(card.getRarity());

        // Calculate the base price using the existing method
        int basePrice = calculateCardPrice(card);

        // Apply the multiplier to the base price
        return (int) (basePrice * rarityMultiplier);
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

    private void refreshInventory() {
        inventory.clear();
        // Add common cards to the inventory
        List<Card> commonCards = getCommonCards();
        addCardsToInventory(commonCards, 0.60);

        // Add boss cards to the inventory
        List<Card> bossCards = getBossCards();
        addCardsToInventory(bossCards, 0.005);

        // Add party cards to the inventory
        List<Card> partyCards = getPartyCards();
        addCardsToInventory(partyCards, 0.005);

        // Add specialty cards to the inventory
        List<Card> specialtyCards = getspecialtyCards();
        addCardsToInventory(specialtyCards, 0.35);

        // Add unique cards to the inventory
        List<Card> uniqueCards = getUniqueCards();
        addCardsToInventory(uniqueCards, 0.04);
    }

    private void addCardsToInventory(List<Card> cards, double probability) {
        for (Card card : cards) {
            if (random.nextDouble() < probability) {
                inventory.add(card);
            }
        }
    }

    private void displayShopStock() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getName());
        }
    }

    private int getUserChoice() {
        // You need to implement this method to get the user's choice from the console input
        return 0;
    }

    private int getPlayerChoice(String message, int min, int max) {
        // You need to implement this method to get the player's choice from the console input
        return 0;
    }
}
