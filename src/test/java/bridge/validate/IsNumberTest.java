package bridge.validate;

import bridge.exception.InvalidIsNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsNumberTest {

    @DisplayName("입력값이 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputIsNumberExceptionTest() {
        assertThatThrownBy(() -> ValidateIsNumber.validate("1a2a3a"))
                .isInstanceOf(InvalidIsNumberException.class);
    }

    @DisplayName("숫자가 들어와 정상 작동하는지 테스트")
    @ValueSource(strings = "1")
    @ParameterizedTest
    void CorrectInputTest(String value) {
        ValidateIsNumber.validate(value);
    }

}
