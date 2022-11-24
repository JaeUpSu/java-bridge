package bridge.validate;

import bridge.exception.InvalidIsNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsNumberTest {

    @DisplayName("입력값이 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputIsNumberExceptionTEST() {
        assertThatThrownBy(() -> ValidateIsNumber.validate("1a2a3a"))
                .isInstanceOf(InvalidIsNumberException.class);
    }
}
