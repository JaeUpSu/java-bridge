package bridge.validate;

import bridge.exception.InvalidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RangeTest {

    @DisplayName("입력값이 범위 외 숫자일때 예외처리 확인하는 테스트")
    @Test
    void InputOutOfRangeExceptionTEST() {
        assertThatThrownBy(() -> ValidateRange.validate(31))
                .isInstanceOf(InvalidRangeException.class);
    }
}
