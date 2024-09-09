package domain.card;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    @DisplayName("카드는 숫자랑 모양을 갖는다.")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> Card.getInstance(CardShape.CLOVER, CardNumber.ACE));
    }

    @Test
    @DisplayName("없는 카드를 찾으면 예외를 발생시킨다.")
    void constructorExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Card.getInstance(null, CardNumber.EIGHT));
    }
}