
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    @DisplayName("2장의 합계가 16이하면 카드를 추가로 받을 수 있다.")
    void dealerCanGetBonusCardTest(){
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(CardShape.CLOVER,CardNumber.JACK));
        dealer.receiveCard(new Card(CardShape.HEART,CardNumber.SIX));
        assertThat(dealer.isPossibleBonus()).isTrue();
    }


    @Test
    @DisplayName("2장의 합계가 17이상이면 카드를 추가로 받을 수 없다.")
    void dealerCanNotGetBonusCardTest(){
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(CardShape.CLOVER,CardNumber.QUEEN));
        dealer.receiveCard(new Card(CardShape.HEART,CardNumber.JACK));
        assertThat(dealer.isPossibleBonus()).isFalse();
    }
}
