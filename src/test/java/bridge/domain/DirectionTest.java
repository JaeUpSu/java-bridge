package bridge.domain;

import static bridge.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Direction Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DirectionTest {

    // 실행하는 메서드명 _ 테스트로 보려는 내용
    // ValueSource 입력한 배열 차례대로 수행
    // CsvSource 입력값과 기댓값을 짝지어 테스트 수행

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3})
    void toCommand_메서드는_범위_외의_값을_입력받는_경우_예외처리(Integer code) {
        assertThatThrownBy(() -> toCommand(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0과 1사이의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"1, U", "0, D"})
    void toCommand_메서드는_0과_1사이의_값을_받아_방향에_대한_머리글자를_반환(Integer code, String expected) {
        assertThat(toCommand(code)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "p", "1", " "})
    void toEnum_메서드는_범위_외의_값을_입력받는_경우_예외처리(String letter) {
        assertThatThrownBy(() -> toEnum(letter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("U와 D 중 하나의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"U, UP", "D, DOWN"})
    void toEnum_메서드는_U와_D를_받아_해당하는_Direction_반환(String letter, Direction expected) {
        assertThat(toEnum(letter)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"UP, false", "DOWN, true"})
    void isNotSameDirection_메서드는_다른_방향인지_부울형_값_반환(Direction direction, boolean expected) {
        assertThat(UP.isNotSameDirection(direction)).isEqualTo(expected);
    }
}
