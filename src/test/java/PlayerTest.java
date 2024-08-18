import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("받은 카드의 합계가 21을 초과하지 않으면 추가 카드를 받을 수 있다.")
    void playerCanGetBonusCardTest(){
        Player player = new Player("윤미");
        player.receiveCard(new Card(CardShape.CLOVER,CardNumber.JACK));
        player.receiveCard(new Card(CardShape.HEART,CardNumber.SIX));
        assertThat(player.isPossibleBonus()).isTrue();
    }

    @Test
    @DisplayName("받은 카드의 합계가 21을 초과하면 추가 카드를 받을 수 없다.")
    void playerCanNotGetBonusCardTest(){
        Player player = new Player("윤미");
        player.receiveCard(new Card(CardShape.CLOVER,CardNumber.ACE));
        player.receiveCard(new Card(CardShape.HEART,CardNumber.SIX));
        player.receiveCard(new Card(CardShape.DIAMOND,CardNumber.KING));
        assertThat(player.isPossibleBonus()).isFalse();
    }
}
