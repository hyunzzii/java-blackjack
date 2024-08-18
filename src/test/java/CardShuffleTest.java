import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardShuffleTest {

    @Test
    @DisplayName("카드를 고른다.")
    void cardShuffleTest(){
        CardShuffle cardSuffle = new RandomCardShuffle();
        assertThat(cardSuffle.shuffle()).isInstanceOf(Card.class);
    }
}
