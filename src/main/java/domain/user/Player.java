package domain.user;

import domain.card.Card;
import domain.state.DeckState;
import domain.state.Score;

public class Player {
    private static final Integer WIN_NUM = 1;
    private static final Integer LOSE_NUM = -1;
    private final DeckState deckState;
    private final String name;
    private final Integer winOrLose;


    public Player(final String name, final DeckState deckState) {
        validate(name, deckState);
        this.name = name;
        this.deckState = deckState;
        this.winOrLose = null;
    }

    public Player(final String name, final DeckState deckState, final Integer winOrLose) {
        validate(name, deckState);
        this.name = name;
        this.deckState = deckState;
        this.winOrLose = winOrLose;
    }

    private void validate(final String name, final DeckState deckState) {
        if (name == null || deckState == null) {
            throw new IllegalArgumentException("null 값이 들어갈 수 없습니다.");
        }
    }

    public Player draw(final Card card) {
        return new Player(name, deckState.draw(card));
    }

    public Player stay() {
        return new Player(name, deckState.stay());
    }

    public Boolean isFinished() {
        return deckState.isFinished();
    }

    public Score getScore() {
        return deckState.calculateScore();
    }

    public String getName() {
        return name;
    }

    public DeckState getDeckState() {
        return deckState;
    }
}
