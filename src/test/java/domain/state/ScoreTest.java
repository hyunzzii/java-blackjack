package domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    @Test
    @DisplayName("score는 생성자 테스트")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> new Score(0));
    }

    @Test
    @DisplayName("score는 Ace 계산을 한다.")
    void addTest() {
        //given
        Score score = new Score(20);
        score.add(10);

        assertThat(score.isBust()).isFalse();
    }

    @Test
    @DisplayName("score는 Blackjack인지 판단한다.")
    void isBlackjackTest() {
        //given
        Score score = new Score(21);
        //then & when
        assertThat(score.isBlackjack()).isTrue();
    }

    @Test
    @DisplayName("score는 Bust인지 판단한다.")
    void isBustTest() {
        //given
        Score score = new Score(22);

        assertThat(score.isBust()).isTrue();
    }
}
