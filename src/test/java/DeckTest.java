import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class DeckTest {
//    @Test
//    @DisplayName("52장의 카드를 가지고 있어야 한다.")
//    void deckHas52Cards(){
//        assertThatNoException().isThrownBy(()->new Deck());
//    }

        @Test
        @DisplayName("카드가 존재하는가")
        void deckHas52CardsTest(){
            Deck deck = new Deck();
            assertThat(deck.hasCard(new Card(CardShape.CLOVER,CardNumber.JACK))).isTrue();
        }
}
