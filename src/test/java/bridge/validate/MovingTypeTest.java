package bridge.validate;

import bridge.exception.InvalidMovingTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingTypeTest {

    @DisplayName("입력값이 숫자일때 예외처리 확인하는 테스트")
    @Test
    void InputNumberExceptionTest() {
        assertThatThrownBy(() -> ValidateMovingType.validate("12"))
                .isInstanceOf(InvalidMovingTypeException.class);
    }

    @DisplayName("입력값이 허용 외의 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputWrongStringExceptionTest() {
        assertThatThrownBy(() -> ValidateMovingType.validate("Z"))
                .isInstanceOf(InvalidMovingTypeException.class);
    }

    @DisplayName("U 혹은 D 가 들어와 정상 작동하는지 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void CorrectInputTest(String value) {
        ValidateMovingType.validate(value);
    }

}
