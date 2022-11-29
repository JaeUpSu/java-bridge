package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
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
    @ValueSource(ints = {0, 21, -1, 1000})
    void valueOf_메서드는_범위를_벗어난_값을_입력받으면_예외처리_한다(int round) {
        Assertions.assertThatThrownBy(() -> Round.valueOf(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void valueOf_메서드는_범위내의_값을_입력받으면_정상처리_한다(int round) {
        Round result = Round.valueOf(round);
        assertThat(result).isInstanceOf(Round.class);
    }

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
        List<Round> rounds = IntStream.rangeClosed(1, 20)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());

        assertThat(Round.order()).hasSameElementsAs(rounds);
    }

    @Test
    void orderWithSize_메서드는_size_만큼_Round_오름차순하여_반환() {
        List<Round> rounds = IntStream.rangeClosed(1, 5)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());

        assertThat(Round.orderWithSize(5)).hasSameElementsAs(rounds);
    }

    @Test
    void orderWithSize_메서드는_범위를_벗어난_값_입력_예외처리() {
        assertThatThrownBy(() -> Round.orderWithSize(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 범위를 벗어났습니다.");
    }
}
