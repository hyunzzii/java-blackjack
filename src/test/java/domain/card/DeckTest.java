package domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    @DisplayName("카드의 점수 총합을 계산한다.")
    void deckSumTest() {
        //given
        Deck cardLump = new Deck();
        cardLump.addCard(Card.getInstance(CardShape.DIAMOND, CardNumber.NINE));
        cardLump.addCard(Card.getInstance(CardShape.CLOVER, CardNumber.ACE));
        cardLump.addCard(Card.getInstance(CardShape.HEART, CardNumber.JACK));
        //when,then
        assertThat(cardLump.sum()).isEqualTo(20);
    }
}
