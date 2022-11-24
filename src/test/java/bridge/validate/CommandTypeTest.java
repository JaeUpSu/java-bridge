package bridge.validate;

import bridge.exception.InvalidCommandTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTypeTest {

    @DisplayName("입력값이 숫자일때 예외처리 확인하는 테스트")
    @Test
    void InputNumberExceptionTest() {
        assertThatThrownBy(() -> ValidateCommandType.validate("12"))
                .isInstanceOf(InvalidCommandTypeException.class);
    }

    @DisplayName("입력값이 허용 외의 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputWrongStringExceptionTest() {
        assertThatThrownBy(() -> ValidateCommandType.validate("Z"))
                .isInstanceOf(InvalidCommandTypeException.class);
    }

    @DisplayName("R 혹은 Q 가 들어와 정상 작동하는지 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void CorrectInputTest(String value) {
        ValidateCommandType.validate(value);
    }


}
