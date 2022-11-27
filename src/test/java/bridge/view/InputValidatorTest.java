package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"A", "", " ", "하", "!"})
    void validateBridgeSize_메서드는_숫자가_아닌_값을_입력하면_예외처리한다(String input) {
        Assertions.assertThatThrownBy(() -> inputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 숫자 형식입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "999"})
    void validateBridgeSize_메서드는_범위_외의_값을_입력하면_예외처리한다(String input) {
        Assertions.assertThatThrownBy(() -> inputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리의 길이는 3에서 20 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "19", "20"})
    void validateBridgeSize_메서드는_범위_내의_값을_입력하면_정상처리한다(String input) {
        inputValidator.validateBridgeSize(input);
    }


    @ParameterizedTest
    @ValueSource(strings = {"u", "1", "위", "", " U"})
    void validateMoving_메서드는_허용_외의_값을_입력하면_예외처리한다(String input) {
        Assertions.assertThatThrownBy(() -> inputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 방향은 위: U, 아래:D 중 하나여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateMoving_메서드는_허용하는_값을_입력하면_정상처리한다(String input) {
        inputValidator.validateMoving(input);
    }


}
