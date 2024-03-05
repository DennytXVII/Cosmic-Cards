package cosmiccards;

import java.util.ArrayList;
import java.util.List;

public abstract class NPC implements GameCharacter {
    private final String name;
    private final List<Card> hand;

    public NPC(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }


    // Implement methods for NPC behavior, such as playing cards, making decisions, etc.
    // This could include methods like playCard(), makeDecision(), etc.
}
