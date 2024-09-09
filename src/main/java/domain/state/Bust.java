package domain.state;

import domain.card.Card;
import domain.card.Deck;

public class Bust extends Finished {
    private final Deck deck;

    public Bust(final Deck deck) {
        validate(deck);
        this.deck = deck;
    }

    private void validate(final Deck deck) {
        if (deck.sum() <= BLACKJACK_NUMBER) {
            throw new IllegalArgumentException("Bust 카드패가 아닙니다.");
        }
    }

    @Override
    public Score calculateScore() {
        Score score = new Score(deck.sum());
        for (int i = 0; i < deck.aceCount(); i++) {
            score = score.add(10);
        }
        return score;
    }

    @Override
    public Deck getDeck() {
        return deck;
    }
}
