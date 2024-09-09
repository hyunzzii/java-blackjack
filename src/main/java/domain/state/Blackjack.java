package domain.state;

import domain.card.Card;
import domain.card.Deck;

public class Blackjack extends Running {
    private final Deck deck;

    public Blackjack(final Deck deck) {
        validate(deck);
        this.deck = deck;
    }

    private void validate(final Deck deck) {
        if (!deck.sum().equals(BLACKJACK_NUMBER)) {
            throw new IllegalArgumentException("Blackjack 카드패가 아닙니다.");
        }
    }

    public DeckState draw(final Card card) {
        deck.addCard(card);
        return new Bust(deck);
    }

    @Override
    public DeckState stay() {
        return new Stay(deck);
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
