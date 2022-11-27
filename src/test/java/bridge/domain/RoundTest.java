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

    @Test
    void nextRound_메서드를_사용해_라운드_1_증가() {
        Round round = Round.valueOf(1);
        Round next = round.nextRound();

        assertThat(next).isEqualTo(Round.valueOf(2));
    }

    @Test
    void firstRound_메서드를_사용해_라운드_1_로_초기화() {
        Round round = Round.firstRound();
        assertThat(round).isEqualTo(Round.valueOf(1));
    }

    @Test
    void order_메서드는_Round_오름차순하여_반환() {
        List<Round> rounds = IntStream.rangeClosed(MINIMUM_ROUND, MAXIMUM_ROUND)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());

        assertThat(Round.order()).hasSameElementsAs(rounds);
    }
}
