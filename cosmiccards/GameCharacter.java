package cosmiccards;

import java.util.List;

public interface GameCharacter {
    String getName();
    List<Card> getHand();
    void chooseInitialCards();
    // Other common methods...
}
