package domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import domain.card.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BlackjackTest {
    @Test
    @DisplayName("받은 카드의 총합이 21 이면 Blackjack 상태이다.")
    void constructorTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when, then
        assertThatNoException().isThrownBy(() -> new Blackjack(deck));
    }

    @Test
    @DisplayName("받은 카드의 총합이 21이 아니면 예외가 발생한다.")
    void constructorExceptionTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.TWO));
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new Blackjack(deck));
    }

    @Test
    @DisplayName("Blackjack -> Bust")
    public void blackjackToBustTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when
        DeckState deckState = new Blackjack(deck);
        DeckState actualState = deckState.draw(Card.getInstance(CardShape.SPADE, CardNumber.ACE));
        //then
        assertThat(actualState).isInstanceOf(Bust.class);
    }

    @Test
    @DisplayName("Blackjack -> Stay")
    public void blackjackToStayTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when
        DeckState deckState = new Blackjack(deck);
        //then
        assertThat(deckState.stay()).isInstanceOf(Stay.class);
    }
}
