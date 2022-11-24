package bridge.validate;

import bridge.exception.InvalidCommandTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTypeTest {

    @DisplayName("입력값이 숫자일때 예외처리 확인하는 테스트")
    @Test
    void InputNumberExceptionTEST() {
        assertThatThrownBy(() -> ValidateCommandType.validate("12"))
                .isInstanceOf(InvalidCommandTypeException.class);
    }

    @DisplayName("입력값이 허용 외의 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputWrongStringExceptionTEST() {
        assertThatThrownBy(() -> ValidateCommandType.validate("Z"))
                .isInstanceOf(InvalidCommandTypeException.class);
    }
}
