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

public class StayTest {
    @Test
    @DisplayName("받은 카드의 총합이 21 이하이면서 카드를 더이상 받지 않으면 Stay 상태이다.")
    void constructorTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when, then
        assertThatNoException().isThrownBy(() -> new Stay(deck));
    }

    @Test
    @DisplayName("받은 카드의 총합이 21 초과면 예외를 발생한다.")
    void constructorExceptionTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.NINE));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new Stay(deck));
    }

    @Test
    @DisplayName("stay 에서 갈 수 있는 상태는 없다: draw")
    public void canNotDrawTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when
        DeckState deckState = new Stay(deck);
        //then
        assertThatIllegalStateException().isThrownBy(
                () -> deckState.draw(Card.getInstance(CardShape.CLOVER, CardNumber.EIGHT)));
    }

    @Test
    @DisplayName("stay 에서 갈 수 있는 상태는 없다: stay")
    public void canNotStayTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.FOUR));
        //when
        DeckState deckState = new Stay(deck);
        //then
        assertThatIllegalStateException().isThrownBy(
                () -> deckState.stay());
    }
}
