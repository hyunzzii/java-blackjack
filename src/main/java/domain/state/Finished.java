package domain.state;

import domain.card.Card;

public abstract class Finished implements DeckState{
    @Override
    public DeckState draw(final Card card) {
        throw new IllegalStateException("지원하지 않는 기능입니다.");
    }

    @Override
    public DeckState stay() {
        throw new IllegalStateException("지원하지 않는 기능입니다.");
    }
    @Override
    public Boolean isFinished(){
        return true;
    }
}
