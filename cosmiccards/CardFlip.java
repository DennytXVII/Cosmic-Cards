package cosmiccards;

import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

public class CardFlip {
    private static boolean flipped = false;

    // Method to flip a card horizontally by 90 degrees
    public static BufferedImage flipHorizontally(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                flippedImage.setRGB(width - x - 1, y, image.getRGB(x, y));
            }
        }
        flipped = !flipped; // Toggle the flipped state
        return flippedImage;
    }

    // Method to change the image of a card based on its flipped state
    public static BufferedImage changeCardImage(BufferedImage originalImage, BufferedImage newImage) {
        if (flipped) {
            return newImage; // Return the new image if the card is flipped
        } else {
            return originalImage; // Return the original image if the card is not flipped
        }
    }


    // Method to flip the card vertically
    public static BufferedImage flipVertically(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -height));

        flippedImage.createGraphics().drawImage(image, at, null);
        return flippedImage;
    }
}


