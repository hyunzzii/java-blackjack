package domain.dispenser;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {

    @Test
    @DisplayName("셔플 카드에서 카드를 없앤다.")
    void deckRemoveCardTest(){
        Cards deck = new Cards();
        Card card = Card.getInstance(CardShape.CLOVER,CardNumber.JACK);
        deck.subCard(card);
    }
}