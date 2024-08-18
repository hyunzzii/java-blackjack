import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDispenserTest {

    CardDispenser cardDispenser;

    @BeforeEach
    void setCardDispenser(){
        this.cardDispenser = new CardDispenser(new CardShuffle() {
            @Override
            public Card shuffle() {
                return new Card(CardShape.CLOVER,CardNumber.EIGHT);
            }
        });
    }

    @Test
    @DisplayName("1장의 카드를 나눠준다.")
    void cardShuffleTest(){
        assertThat(cardDispenser.giveACard().match(new Card(CardShape.CLOVER,CardNumber.EIGHT))).isTrue();
    }
}
