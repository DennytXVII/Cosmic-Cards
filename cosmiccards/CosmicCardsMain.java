package cosmiccards;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class CosmicCardsMain {
    private Player player1, player2;
    private Card[][] board;
    private Player turn;
    private Random random;
    private Animation[][] animations;

    public void CosmicCards(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Card[3][3];
        this.random = new Random();
        this.turn = random.nextBoolean() ? player1 : player2;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Initialize the board with an empty card
                board[i][j] = new Card("Empty", 0, 0, 0, 0);
            }
        }
    }
        public void displayBoard() {
            System.out.println("   1  2  3");
            for (int i = 0; i < 3; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print("[" + board[i][j].getName() + "] ");
                    // Display the animation for this slot, if any
                    if (animations[i][j] != null) {
                        JLabel animationLabel = new JLabel(animations[i][j].getImageIcon());
                        // Add the label to the game board panel or frame
                        // For example, if your game board is a JPanel:
                        // gameBoardPanel.add(animationLabel);
                    }
                }
                System.out.println();
            }
        }

    public boolean placeCard(Player player, int row, int col) {
        if (board[row][col].getName().equals("Empty")) {
            board[row][col] = player.getHand().remove(0);
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if (!isBoardFull()) {
            return false; // The match ends only when the board is full
        }

        int player1Count = countPlayerCards(player1);
        int player2Count = countPlayerCards(player2);
        return player1Count > player2Count; // Player 1 wins if they have more cards on the board
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getName().equals("Empty")) {
                    return false; // If any slot is empty, the board is not full
                }
            }
        }
        return true; // All slots are filled
    }

    private int countPlayerCards(Player player) {
        int count = 0;
        String playerName = player.getName();
        // Count the cards on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getName().equals(playerName)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void play() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean draw = false;
            while (!checkWin() && !draw) {
                displayBoard();
                System.out.println(turn.getName() + "'s turn");
                System.out.print("Enter row (1-3): ");
                int row = Main.getValidInput(scanner, 1, 3) - 1;
                System.out.print("Enter column (1-3): ");
                int col = Main.getValidInput(scanner, 1, 3) - 1;
                if (placeCard(turn, row, col)) {
                    turn = (turn == player1) ? player2 : player1;
                } else {
                    System.out.println("Invalid move! Try again.");
                }

                // Check for draw
                if (checkDraw()) {
                    System.out.println("The game ends in a draw!");
                    draw = true;
                }
            }

            if (!draw) {
                displayBoard(); // Display the final board state
                System.out.println(turn.getName() + " wins!");
                // Reward for winning: Choose a card from the opponent's hand
                chooseCardFromOpponent(turn == player1 ? player2 : player1, scanner);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers.");
        }
    }

    private boolean checkDraw() {
        // Check if the board is full and neither player has more than half of the total cards
        int player1Count = countPlayerCards(player1);
        int player2Count = countPlayerCards(player2);
        int totalCards = 9 + 1; // Total cards on the board plus one card in the second player's hand
        return player1Count <= totalCards / 2 && player2Count <= totalCards / 2;
    }

    private void chooseCardFromOpponent(Player opponent, Scanner scanner) {
        // Allow the winner to choose a card from the opponent's hand
        List<Card> opponentHand = opponent.getHand();
        System.out.println("Choose a card from " + opponent.getName() + "'s hand:");
        for (int i = 0; i < opponentHand.size(); i++) {
            System.out.println((i + 1) + ": " + opponentHand.get(i).getName());
        }
        System.out.print("Enter the number of the card you want to take: ");
        int choice = Main.getValidInput(scanner, 1, opponentHand.size());
        if (choice > 0 && choice <= opponentHand.size()) {
            // Add the chosen card to the winner's hand
            turn.getHand().add(opponentHand.remove(choice - 1));
            System.out.println(turn.getName() + " took a card from " + opponent.getName() + "'s hand.");
        } else {
            System.out.println("Invalid choice. No card taken.");
        }
    }
}

