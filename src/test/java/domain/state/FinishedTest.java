package domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import domain.card.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FinishedTest {
    @Test
    @DisplayName("Bust은 Finished 상태이다.")
    void bustFinishedTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.NINE));
        DeckState deckState = new Bust(deck);
        //when,then
        assertThat(deckState.isFinished()).isTrue();
    }

    @Test
    @DisplayName("Stay는 Finished 상태이다.")
    void stayFinishedTest() {
        //given
        Hit hit = new Hit();
        DeckState deckState = hit.draw(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN))
                .draw(Card.getInstance(CardShape.HEART, CardNumber.NINE));
        //when,then
        assertThat(deckState.stay().isFinished()).isTrue();
    }
}
