package domain.state;

import domain.card.Card;

public interface DeckState {
    static final Integer BLACKJACK_NUMBER = 21;
    DeckState draw(Card card);
    DeckState stay();
    Boolean isFinished();
    Score getScore();
}
