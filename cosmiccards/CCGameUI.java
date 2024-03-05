package cosmiccards;

import com.sun.javafx.scene.traversal.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CCGameUI extends JFrame {
    private JPanel boardPanel;
    private JButton chooseCardsButton; // Button to choose cards

    private CardJournal cardJournal; // Reference to the CardJournal
    private List<String> playerCards; // Player's cards for the game

    public CCGameUI(CardJournal cardJournal) {
        this.cardJournal = cardJournal;
        this.playerCards = new ArrayList<>();

        setTitle("Cosmic Cards");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize UI components
        initializeBoardPanel();
        initializeButton();

        // Add components to the main frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(boardPanel, BorderLayout.CENTER);
        getContentPane().add(chooseCardsButton, BorderLayout.NORTH);
    }

    private void initializeBoardPanel() {
        boardPanel = new JPanel();
        // Load and display the board image
        ImageIcon boardImage = new ImageIcon("Board/Field.png");
        JLabel boardLabel = new JLabel(boardImage);
        boardPanel.add(boardLabel);
    }

    private void initializeButton() {
        chooseCardsButton = new JButton("Choose Cards");
        chooseCardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call method to choose cards
                chooseCardsFromJournal();
            }
        });
    }

    private void chooseCardsFromJournal() {
        // Get available cards from the CardJournal
        List<String> availableCards = cardJournal.getAllCards();

        // Create checkboxes for each available card owned by the player
        List<JCheckBox> checkboxes = new ArrayList<>();
        for (String card : availableCards) {
            if (playerCards.contains(card)) {
                JCheckBox checkBox = new JCheckBox(card);
                checkboxes.add(checkBox);
            }
        }

        if (checkboxes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You don't have any cards to choose from.");
            return;
        }

        // Create a dialog to display available cards
        JDialog dialog = new JDialog(this, "Choose Your Cards", true);
        JPanel cardsPanel = new JPanel(new GridLayout(0, 1));

        // Add checkboxes to the panel
        for (JCheckBox checkBox : checkboxes) {
            cardsPanel.add(checkBox);
        }

        // Create a button to confirm selection
        JButton confirmButton = new JButton("Confirm Selection");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected cards
                List<String> selectedCards = new ArrayList<>();
                for (JCheckBox checkBox : checkboxes) {
                    if (checkBox.isSelected()) {
                        selectedCards.add(checkBox.getText());
                    }
                }

                if (selectedCards.size() != 5) {
                    JOptionPane.showMessageDialog(dialog, "Please select exactly 5 cards.");
                    return;
                }

                // Close the dialog
                dialog.dispose();

                // Proceed with the game using the selected cards
                startGame(selectedCards);
            }
        });

        // Add components to the dialog
        dialog.setLayout(new BorderLayout());
        dialog.add(cardsPanel, BorderLayout.CENTER);
        dialog.add(confirmButton, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void startGame(List<String> selectedCards) {
        // Implement game logic using the selected cards
        // For demonstration purposes, we'll just print the selected cards
        System.out.println("Selected cards for the game:");
        for (String card : selectedCards) {
            System.out.println(card);
        }
        // You can proceed with the actual game logic here
    }

    public static void main(String[] args) {
        CardJournal cardJournal = new CardJournal();
        CCGameUI gameUI = new CCGameUI(cardJournal);
        SwingUtilities.invokeLater(() -> {
            gameUI.setVisible(true);
        });
    }
    // Method to handle card flipping
    public void flipCard(Card card, Direction attackDirection) {
        BufferedImage originalImage = card.getImage(); // Assuming card has a getImage() method to retrieve its image
        BufferedImage flippedImage;

        if (attackDirection == Direction.LEFT || attackDirection == Direction.RIGHT) {
            flippedImage = CardFlip.flipHorizontally(originalImage);
        } else if (attackDirection == Direction.UP || attackDirection == Direction.DOWN) {
            flippedImage = CardFlip.flipVertically(originalImage);
        } else {
            flippedImage = originalImage; // No flip if the attack direction is unknown or invalid
        }

        // Change the image of the card based on its flipped state
        BufferedImage newImage = CardFlip.changeCardImage(originalImage, flippedImage);
        card.setImage(String.valueOf(newImage)); // Set the flipped image as the new image of the card
    }
}

