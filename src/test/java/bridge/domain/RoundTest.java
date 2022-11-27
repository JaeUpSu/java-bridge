package bridge.domain;

import static bridge.domain.Round.MAXIMUM_ROUND;
import static bridge.domain.Round.MINIMUM_ROUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DisplayName("Round 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RoundTest {

    // isInstanceOf => 어떤 객체가 나오는지 확인

    // IntStream => 정수형 Stream
    // rangeClosed(min, max) => 범위 적용
    // mapToObj(Class::Method) => 요소 하나하나 클래스 내의 메서드 적용

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM_ROUND - 1, MAXIMUM_ROUND + 1, 9999})
    void 생성자는_범위밖의_값을_입력하면_예외처리(int number) {
        assertThatThrownBy(() -> new Round(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 범위를 벗어났습니다.");
    }
    @Test
    void 매개변수_없는_생성자는_라운드_1로_시작(int number) {
        assertThat(new Round()).isEqualTo(new Round(1));
    }

    @Test
    void nextRound_메서드를_사용해_허용된_범위를_넘어간다면_예외처리() {
        Round round = new Round(MAXIMUM_ROUND);

        assertThatThrownBy(round::nextRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 범위를 벗어났습니다.");
    }

    @Test
    void nextRound_메서드를_사용해_라운드_1_증가() {
        Round round = new Round(1);
        round.nextRound();

        assertThat(round).isEqualTo(new Round(2));
    }

    @Test
    void reset_메서드를_사용해_라운드_1_로_초기화() {
        Round round = new Round(1);
        round.nextRound();
        round.reset();

        assertThat(round).isEqualTo(new Round(1));
    }

    @Test
    void order_메서드는_Round_오름차순하여_반환() {
        List<Round> rounds = IntStream.rangeClosed(MINIMUM_ROUND, MAXIMUM_ROUND)
                .mapToObj(Round::new)
                .collect(Collectors.toList());

        assertThat(Round.order()).hasSameElementsAs(rounds);
    }
}
