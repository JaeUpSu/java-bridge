package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("MoveStatus Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MoveStatusTest {

    @ParameterizedTest
    @CsvSource({"ABLE, O", "UNABLE, X"})
    void get_메서드는_성공일_경우_실패일_경우_각_O또는_X를_반환(MoveStatus moveStatus, String expected) {
        Assertions.assertThat(moveStatus.get()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"ABLE, false", "UNABLE, true"})
    void isFail_메서드는_실패일_경우_true_아니면_false_를_반환(MoveStatus moveStatus, boolean expected) {
        Assertions.assertThat(moveStatus.isFail()).isEqualTo(expected);
    }
}
