package cosmiccards;

import java.util.*;

public class SupportCard extends Card {
    private SupportType supportType;
    private Element element;
    private int coverageRadius;

    public SupportCard(String name, Element element, SupportType supportType, int coverageRadius) {
        super(name, element, 0, 0, 0, 0);
        this.supportType = supportType;
        this.element = element;
        this.coverageRadius = coverageRadius;
    }

    public void activateSupportEffect(Board board, int row, int col) {
        if (isValidIndex(board, row, col)) {
            switch (supportType) {
                case ELEMENT_DIMENSION:
                    changeBoardElement(board, row, col);
                    break;
            }
        } else {
            System.out.println("Invalid board position.");
        }
    }

    private void changeBoardElement(Board board, int row, int col) {
        // Implementation to change board element goes here
    }

    private boolean isValidIndex(Board board, int row, int col) {
        return row >= 0 && row < board.getNumRows() && col >= 0 && col < board.getNumCols();
    }

    public SupportType getSupportType() {
        return supportType;
    }

    public Element getElement() {
        return element;
    }

    public int getCoverageRadius() {
        return coverageRadius;
    }

    public enum Element {
        FIRE,
        WATER,
        EARTH,
        WIND,
        DARKNESS,
        LIGHT,
        THUNDER,
        NO_ELEMENT,
        // Add more elements as needed
    }

}
