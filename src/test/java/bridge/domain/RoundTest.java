package bridge.domain;

import static bridge.domain.Round.MAXIMUM_ROUND;
import static bridge.domain.Round.MINIMUM_ROUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Round 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RoundTest {

    // isInstanceOf => 어떤 객체가 나오는지 확인

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM_ROUND - 1, MAXIMUM_ROUND + 1, 9999})
    void valueOf_메서드는_범위밖의_값을_입력하면_예외처리(int number) {
        assertThatThrownBy(() -> Round.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM_ROUND, MAXIMUM_ROUND})
    void valueOf_메서드는_범위내의_값을_입력하면_Round_인스턴스를_반환(int number) {
        assertThat(Round.valueOf(number)).isInstanceOf(Round.class);
    }
}
