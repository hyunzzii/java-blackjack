package domain.dispenser;

import domain.card.Card;
import java.util.Collections;
import java.util.List;

public class RandomDispenser implements Dispenser{
    private final Cards deck;

    public RandomDispenser(){
        this.deck = new Cards();
    }

    public Card shuffle(){
        List<Card> deckShuffle = deck.getDeck();
        Collections.shuffle(deckShuffle);
        Card card = deckShuffle.get(0);
        deck.subCard(card);
        return card;
    }
}
