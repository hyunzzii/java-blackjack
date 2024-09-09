package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public Integer sum() {
        return deck.stream()
                .map(Card::getNumber)
                .reduce(0, Integer::sum);
    }

    public Long aceCount() {
        return deck.stream().map(Card::isAce).count();
    }

    public List<Card> getCards() {
        return deck;
    }
}
