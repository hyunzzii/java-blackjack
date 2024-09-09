package domain.state;

import domain.card.Card;
import domain.card.Deck;

public abstract class Running implements DeckState {
    @Override
    public Boolean isFinished() {
        return false;
    }
}
