import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BlackJackTest {
    BlackJack blackJack;

    @BeforeEach
    void blackJackSetUP() {
        CardDispenser cardDispenser = new CardDispenser(new CardShuffle() {
            @Override
            public Card shuffle() {
                return new Card(CardShape.CLOVER, CardNumber.EIGHT);
            }
        });
        this.blackJack = new BlackJack();
    }

    @Test
    @DisplayName("플레이어와 딜러에게 카드를 2장씩 나눠준다.")
    void init() {
        Players players = new Players(List.of(new Player("윤미")));
        Dealer dealer = new Dealer();
        blackJack.init(dealer, players);
        asserThat(dealer.)
    }
}
