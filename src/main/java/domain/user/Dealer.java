package domain.user;

import domain.card.Card;
import domain.state.DeckState;
import domain.state.Score;

public class Dealer {
    private static final Integer DEALER_GET_CARD_SCORE = 16;
    private final DeckState deckState;

    public Dealer(final DeckState deckState) {
        validate(deckState);
        this.deckState = deckState;
    }

    private void validate(final DeckState deckState) {
        if (deckState == null) {
            throw new IllegalArgumentException("null 값이 들어갈 수 없습니다.");
        }
    }

    public Dealer draw(final Card card) {
        if(deckState.getScore().isWin(new Score(DEALER_GET_CARD_SCORE))) {
            return this;
        }
        return new Dealer(deckState.draw(card));
    }
    public Score getScore(){
        return deckState.getScore();
    }
}
