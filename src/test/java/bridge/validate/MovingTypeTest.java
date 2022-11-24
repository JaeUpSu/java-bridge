package bridge.validate;

import bridge.exception.InvalidMovingTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingTypeTest {

    @DisplayName("입력값이 숫자일때 예외처리 확인하는 테스트")
    @Test
    void InputNumberExceptionTEST() {
        assertThatThrownBy(() -> ValidateMovingType.validate("12"))
                .isInstanceOf(InvalidMovingTypeException.class);
    }

    @DisplayName("입력값이 허용 외의 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputWrongStringExceptionTEST() {
        assertThatThrownBy(() -> ValidateMovingType.validate("Z"))
                .isInstanceOf(InvalidMovingTypeException.class);
    }
}
