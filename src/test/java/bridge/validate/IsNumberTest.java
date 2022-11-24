package bridge.validate;

import bridge.Application;
import bridge.exception.InvalidIsNumberException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class IsNumberTest {

    @DisplayName("입력값이 문자일때 예외처리 확인하는 테스트")
    @Test
    void InputIsNumberExceptionTEST() {
        assertThatThrownBy(() -> ValidateIsNumber.validate("1a2a3a"))
                .isInstanceOf(InvalidIsNumberException.class);
    }
}
