package domain.state;

public class Score {
    private static final int BLACKJACK_SCORE = 21;

    private final Integer value;

    public Score(final Integer value) {
        this.value = value;
    }

    public Score add(final Integer value) {
        final Score newScore = new Score(this.value + value);
        if (newScore.isBust()) {
            return this;
        }
        return newScore;
    }

    public Boolean isBlackjack() {
        return this.value == BLACKJACK_SCORE;
    }

    public Boolean isBust() {
        return this.value > BLACKJACK_SCORE;
    }

    public Boolean isWin(Score other) {
        if (isBust()) {
            return false;
        }
        return value > other.value;
    }

    public Boolean isDraw(Score other) {
        if (isBust() && other.isBust()) {
            return true;
        }
        return value.equals(other.value);
    }

    public Integer getValue() {
        return this.value;
    }
}
