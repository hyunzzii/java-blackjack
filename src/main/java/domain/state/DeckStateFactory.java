package domain.state;

import domain.card.Card;

public class DeckStateFactory {
    public static DeckState getInstanceWhenGameStart(final Card first, final Card second) {
        return new Hit().draw(first).draw(second);
    }
}
