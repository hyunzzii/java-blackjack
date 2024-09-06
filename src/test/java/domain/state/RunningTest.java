package domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunningTest {
    @Test
    @DisplayName("Hit은 Running 상태이다.")
    void hitRunningTest(){
        //given
        Hit hit = new Hit();
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN))
                .draw(Card.getInstance(CardShape.HEART, CardNumber.NINE));
        //when,then
        assertThat(deckState.isFinished()).isFalse();
    }

    @Test
    @DisplayName("Blackjac은 Running 상태이다.")
    void blackjackRunningTest(){
        //given
        Hit hit = new Hit();
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN))
                .draw(Card.getInstance(CardShape.HEART, CardNumber.NINE))
                        .draw(Card.getInstance(CardShape.HEART, CardNumber.FIVE));
        //when,then
        assertThat(deckState.isFinished()).isFalse();
    }
}
