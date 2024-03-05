package cosmiccards;

import javax.swing.*;
import java.net.URL;

public class Animation {
    private ImageIcon imageIcon;

    public Animation(String imagePath) {
        this.imageIcon = createImageIcon(imagePath);
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    private ImageIcon createImageIcon(String imagePath) {
        URL imgUrl = getClass().getClassLoader().getResource(imagePath);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            System.err.println("Couldn't find file: " + imagePath);
            return null;
        }
    }

    // Dragoon Transformation Animation
    public static Animation getDragoonTransformationAnimation() {
        return new Animation("dragoon_transformation.gif");
    }

    // Element Dimension Animation
    public static Animation getElementDimensionAnimation() {
        return new Animation("element_dimension.gif");
    }

}
