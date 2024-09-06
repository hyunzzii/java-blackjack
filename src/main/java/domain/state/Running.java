package domain.state;

import domain.card.Card;

public abstract class Running implements DeckState{
    @Override
    public Boolean isFinished() {
        return false;
    }
}
