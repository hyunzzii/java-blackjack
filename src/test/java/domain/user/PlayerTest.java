package domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import domain.state.DeckState;
import domain.state.DeckStateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("player는 null값을 가질 수 없다.")
    void constructorTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.NINE);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        //when,then
        assertThatNoException().isThrownBy(() -> new Player("Dore dore", init));
    }

    @Test
    @DisplayName("player는 null값을 가지면 예외가 발생한다.")
    void constructorExceptionTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.NINE);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(null, init));
    }

    @Test
    @DisplayName("player의 DeckState가 변한다. Hit -> Hit")
    void playerHitToHitTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.TWO);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        Player player = new Player("Dore dore", init);
        //when
        Player newPlayer = player.draw(Card.getInstance(CardShape.HEART, CardNumber.THREE));
        assertThat(newPlayer.isFinished()).isFalse();
    }

    @Test
    @DisplayName("player의 DeckState가 변한다. Hit -> Blackjack")
    void playerHitToBlackjackTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.TWO);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        Player player = new Player("Dore dore", init);
        //when
        Player newPlayer = player.draw(Card.getInstance(CardShape.HEART, CardNumber.EIGHT));
        assertThat(newPlayer.isFinished()).isFalse();
    }

    @Test
    @DisplayName("player의 DeckState가 변한다. Hit -> Stay")
    void playerHitToStayTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.NINE);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        Player player = new Player("Dore dore", init);
        //when
        Player newPlayer = player.stay();
        assertThat(newPlayer.isFinished()).isTrue();
    }

    @Test
    @DisplayName("player의 DeckState가 변한다. Hit -> Bust")
    void playerHitToBustTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.NINE);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        Player player = new Player("Dore dore", init);
        //when
        Player newPlayer = player.draw(Card.getInstance(CardShape.HEART, CardNumber.THREE));
        assertThat(newPlayer.isFinished()).isTrue();
    }
}
