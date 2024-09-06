package domain.state;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import domain.card.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BustTest {
    @Test
    @DisplayName("받은 카드의 총합이 21 초과이면 Bust 상태이다.")
    void constructorTest(){
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.NINE));
        //when, then
        assertThatNoException().isThrownBy(()->new Bust(deck));
    }

    @Test
    @DisplayName("받은 카드의 총합이 21 초과가 아니면 예외가 발생한다.")
    void constructorExceptionTest(){
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.TWO));
        //when, then
        assertThatIllegalArgumentException().isThrownBy(()->new Bust(deck));
    }

    @Test
    @DisplayName("Bust 에서 갈 수 있는 상태는 없다: draw")
    void canNotDrawTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.NINE));
        //when
        DeckState deckState = new Bust(deck);
        //then
        assertThatIllegalStateException().isThrownBy(
                () -> deckState.draw(Card.getInstance(CardShape.CLOVER, CardNumber.NINE)));
    }

    @Test
    @DisplayName("Bust 에서 갈 수 있는 상태는 없다: stay")
    void canNotStayTest() {
        //given
        Deck deck = new Deck();
        deck.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.SEVEN));
        deck.addCard(Card.getInstance(CardShape.SPADE, CardNumber.KING));
        deck.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.NINE));
        //when
        DeckState deckState = new Bust(deck);
        //then
        assertThatIllegalStateException().isThrownBy(
                deckState::stay);
    }
}
