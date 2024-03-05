package cosmiccards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LocationPicker extends JFrame implements MouseListener {
    private Image worldMapImage;
    private final String mapImagePath = "C:\\Users\\mtfdo\\Desktop\\CosmicCardsContent\\LocationSelector\\WORLDMAP.tif";

    public LocationPicker() {
        setTitle("Location Picker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load the world map image from the specified path
        try {
            worldMapImage = ImageIO.read(new File(mapImagePath));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load map image.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Add mouse listener to detect clicks
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the world map image
        g.drawImage(worldMapImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Determine the coordinates of the mouse click
        int x = e.getX();
        int y = e.getY();

        // Determine the selected location based on the coordinates
        String selectedLocation = getSelectedLocation(x, y);
        System.out.println("Selected location: " + selectedLocation);
    }

    // Method to determine the selected location based on the coordinates
    private String getSelectedLocation(int x, int y) {
        // Replace this with your logic to determine the selected location based on the image
        // For simplicity, this example returns a hardcoded location based on the coordinates
        if (x < 200 && y < 200) {
            return "Location A";
        } else if (x < 400 && y < 400) {
            return "Location B";
        } else {
            return "Location C";
        }
    }

    // Other mouse listener methods
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LocationPicker locationPicker = new LocationPicker();
            locationPicker.setVisible(true);
        });
    }
}
