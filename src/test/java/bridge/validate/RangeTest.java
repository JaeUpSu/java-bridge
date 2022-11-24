package bridge.validate;

import bridge.exception.InvalidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RangeTest {

    @DisplayName("입력값이 범위 외 숫자일때 예외처리 확인하는 테스트")
    @Test
    void InputOutOfRangeExceptionTest() {
        assertThatThrownBy(() -> ValidateRange.validate(31))
                .isInstanceOf(InvalidRangeException.class);
    }

    @DisplayName("범위 내 숫자가 들어와 정상 작동하는지 테스트")
    @ValueSource(ints = {12})
    @ParameterizedTest
    void CorrectInputTest(Integer value) {
        ValidateRange.validate(value);
    }

}
