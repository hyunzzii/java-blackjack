package domain.state;

import domain.card.Card;
import domain.card.Deck;

public class Hit extends Running {
    private final Deck deck;

    public Hit() {
        deck = new Deck();
    }

    public Hit(final Deck deck) {
        this.deck = deck;
    }

    @Override
    public DeckState draw(final Card card) {
        deck.addCard(card);
        if (deck.sum().equals(BLACKJACK_NUMBER)) {
            return new Blackjack(deck);
        }
        if (deck.sum() > BLACKJACK_NUMBER) {
            return new Bust(deck);
        }
        return new Hit(deck);
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
