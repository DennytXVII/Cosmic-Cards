package cosmiccards;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card extends JPanel {
    private Image cardImage;
    private String characterName;
    private String element;
    private String avccid;

    private static final String ELEMENT_ICON_FOLDER_PATH = "CosmicCardsContent/ElementIcon/";

    public Card(String imagePath, String characterName, String element, String avccid) {
        try {
            cardImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.characterName = characterName;
        this.element = element;
        this.avccid = avccid;
        setPreferredSize(new Dimension(cardImage.getWidth(this), cardImage.getHeight(this)));
    }

    public Card(String imagePath, String cardElement, String avccid) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cardImage != null) {
            // Draw card image
            g.drawImage(cardImage, 0, 0, this);

            // Draw element icon
            String elementIconPath = ELEMENT_ICON_FOLDER_PATH + element + "ElementIcon.png";
            ImageIcon elementIcon = new ImageIcon(elementIconPath);
            if (elementIcon != null) {
                int iconWidth = elementIcon.getIconWidth();
                int iconHeight = elementIcon.getIconHeight();
                int x = getWidth() - iconWidth - 10; // 10 pixels from the right
                int y = 10; // 10 pixels from the top
                elementIcon.paintIcon(this, g, x, y);
            }

            // Draw character name banner
            Font nameFont = new Font("Arial", Font.BOLD, 12);
            g.setFont(nameFont);
            FontMetrics nameMetrics = g.getFontMetrics(nameFont);
            int nameWidth = nameMetrics.stringWidth(characterName);
            int nameHeight = nameMetrics.getHeight();
            int nameX = (getWidth() - nameWidth) / 2;
            int nameY = (int) (getHeight() * 0.6); // Adjust as needed
            g.setColor(Color.BLACK);
            g.fillRect(nameX - 5, nameY - nameHeight + 5, nameWidth + 10, nameHeight);
            g.setColor(Color.WHITE);
            g.drawString(characterName, nameX, nameY);

            // Draw AVCCID in diamond formation
            Font avccidFont = new Font("Arial", Font.PLAIN, 10);
            g.setFont(avccidFont);
            FontMetrics avccidMetrics = g.getFontMetrics(avccidFont);
            int avccidWidth = avccidMetrics.stringWidth(avccid);
            int avccidHeight = avccidMetrics.getHeight();
            int avccidX = 10; // 10 pixels from the left
            int avccidY = 10; // 10 pixels from the top
            g.drawString(avccid, avccidX, avccidY); // Draw the AVCCID
            g.drawString(avccid.substring(0, 1), avccidX + 5, avccidY + avccidHeight); // Top digit
            g.drawString(avccid.substring(1, 2), avccidX, avccidY + 2 * avccidHeight); // Left digit
            g.drawString(avccid.substring(2, 3), avccidX + 2 * avccidWidth, avccidY + 2 * avccidHeight); // Right digit
            g.drawString(avccid.substring(3), avccidX + 5, avccidY + 3 * avccidHeight); // Bottom digit
        }
    }

    // Method to set the card image dynamically
    public void setImage(String imagePath) {
        try {
            cardImage = ImageIO.read(new File(imagePath));
            setPreferredSize(new Dimension(cardImage.getWidth(this), cardImage.getHeight(this)));
            repaint(); // Repaint the panel to reflect the new image
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCardElement() {
    }

    public String getAVCCID() {
    }

    public Object getType() {
    }

    public BufferedImage getImage() {
        return null;
    }
}