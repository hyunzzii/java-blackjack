package domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitTest {
    @Test
    @DisplayName("Hit -> Hit")
    public void hitToHitTest() {
        //given
        Hit hit = new Hit();
        //when
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        DeckState actualState = deckState.draw(Card.getInstance(CardShape.HEART, CardNumber.NINE));
        //then
        assertThat(actualState).isInstanceOf(Hit.class);
    }

    @Test
    @DisplayName("Hit -> Bust")
    public void hitToBustTest() {
        //given
        Hit hit = new Hit();
        //when
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN))
                .draw(Card.getInstance(CardShape.CLOVER, CardNumber.JACK));

        DeckState actualState = deckState.draw(Card.getInstance(CardShape.HEART, CardNumber.NINE));
        //then
        assertThat(actualState).isInstanceOf(Bust.class);
    }

    @Test
    @DisplayName("Hit -> Blackjack")
    public void hitToBlackjackTest() {
        //given
        Hit hit = new Hit();
        //when
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN))
                .draw(Card.getInstance(CardShape.CLOVER, CardNumber.KING));

        DeckState actualState = deckState.draw(Card.getInstance(CardShape.HEART, CardNumber.FOUR));
        //then
        assertThat(actualState).isInstanceOf(Blackjack.class);
    }

    @Test
    @DisplayName("Hit -> Stay")
    public void hitToStayTest() {
        //given
        Hit hit = new Hit();
        //when
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN))
                .draw(Card.getInstance(CardShape.CLOVER, CardNumber.KING));

        DeckState actualState = deckState.stay();
        //then
        assertThat(actualState).isInstanceOf(Stay.class);
    }
}
