package domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import domain.state.DeckState;
import domain.state.DeckStateFactory;
import domain.state.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    @DisplayName("딜러가 추가 카드를 뽑는다.")
    void dealerDrawTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.TWO);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.JACK);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        Dealer dealer = new Dealer(init);
        //when
        Dealer newDealer = dealer.draw(Card.getInstance(CardShape.SPADE, CardNumber.JACK));
        //then
        assertThat(newDealer.getScore().isDraw(new Score(22))).isTrue();
    }

    @Test
    @DisplayName("딜러가 추가 카드를 뽑지 않는다.")
    void dealerNotDrawTest() {
        //given
        Card first = Card.getInstance(CardShape.SPADE, CardNumber.ACE);
        Card second = Card.getInstance(CardShape.DIAMOND, CardNumber.TEN);
        DeckState init = DeckStateFactory.getInstanceWhenGameStart(first, second);
        Dealer dealer = new Dealer(init);
        //when
        Dealer newDealer = dealer.draw(Card.getInstance(CardShape.SPADE, CardNumber.JACK));
        //then
        assertThat(dealer).isEqualTo(newDealer);
    }
}
