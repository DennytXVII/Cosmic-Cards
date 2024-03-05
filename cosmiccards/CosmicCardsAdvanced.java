package cosmiccards;

import java.util.Scanner;

public class CosmicCardsAdvanced extends CosmicCardsMain {
    private CardJournal cardJournal;

    public CosmicCardsAdvanced(Player player1, Player player2, CardJournal cardJournal) {
        super(player1, player2);
        this.board = new Card[4][4]; // Extend the board size to 4x4
        initializeBoard();
        this.cardJournal = cardJournal;
    }

    @Override
    protected void initializeBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = new Card("Empty", 0, 0, 0, 0);
            }
        }
    }

    @Override
    public boolean placeCard(Player player, int row, int col) {
        if (board[row][col].getName().equals("Empty")) {
            board[row][col] = player.getHand().remove(0);
            conquerAdjacentCards(player, row, col); // Check and conquer adjacent cards
            return true;
        }
        return false;
    }

    private void conquerAdjacentCards(Player player, int row, int col) {
        // Check and conquer adjacent cards in all directions
        conquerAdjacentCard(player, row - 1, col); // Check above
        conquerAdjacentCard(player, row + 1, col); // Check below
        conquerAdjacentCard(player, row, col - 1); // Check left
        conquerAdjacentCard(player, row, col + 1); // Check right
    }

    private void conquerAdjacentCard(Player player, int row, int col) {
        if (row >= 0 && row < 4 && col >= 0 && col < 4) { // Check if within bounds
            Card currentCard = board[row][col];
            if (!currentCard.getName().equals("Empty") && !currentCard.getName().equals(player.getName())) {
                if (player.getAttackValue() > currentCard.getDefenseValue()) {
                    board[row][col] = new Card(player.getName(), player.getAttackValue(), player.getDefenseValue(), player.getSpecialValue(), player.getAVCCID());
                }
            }
        }
    }

    @Override
    public boolean checkWin() {
        // Check if a player has no usable cards in hand, on the field, and in the deck
        if (player1.getHand().isEmpty() && player1.getDeck().isEmpty() && countPlayerCards(player1) == 0) {
            return true; // Player 1 loses
        } else if (player2.getHand().isEmpty() && player2.getDeck().isEmpty() && countPlayerCards(player2) == 0) {
            return true; // Player 2 loses
        }
        return false;
    }

    public void play() {
        // Player 1 chooses a deck
        chooseDeckForPlayer(player1);

        // Start the game
        super.play();
    }

    private void chooseDeckForPlayer(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(player.getName() + ", choose a deck:");
        displayDecks(player);
        int deckChoice = scanner.nextInt();
        if (deckChoice >= 1 && deckChoice <= player.getDecks().size()) {
            player.setDeck(player.getDecks().get(deckChoice - 1));
        } else {
            System.out.println("Invalid choice. Defaulting to Deck 1.");
            player.setDeck(player.getDecks().get(0));
        }
    }

    private void displayDecks(Player player) {
        System.out.println("Available decks for " + player.getName() + ":");
        List<Deck> decks = cardJournal.getDecks();
        for (int i = 0; i < decks.size(); i++) {
            System.out.println((i + 1) + ". " + decks.get(i).getName());
        }
    }
}
