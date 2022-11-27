package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BridgeGameStatus Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeGameStatusTest {

    @ParameterizedTest
    @CsvSource({"PLAY, true", "QUIT, false"})
    void isPlayable_메서드는_게임의_진행가능여부를_반환(BridgeGameStatus bridgeGameStatus, boolean result) {
        boolean playable = bridgeGameStatus.isPlayable();
        Assertions.assertThat(playable).isEqualTo(result);
    }

    @Test
    void gameStart_메서드는_PLAY_를_반환() {
        Assertions.assertThat(BridgeGameStatus.gameStart()).isEqualTo(BridgeGameStatus.PLAY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "q", "C"})
    void toEnum_메서드는_허용되지_않는_값_예외처리(String status) {
        Assertions.assertThatThrownBy(() -> BridgeGameStatus.getEnum(status))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("R과 Q 중 하나의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"R, PLAY", "Q, QUIT"})
    void toEnum_메서드는_허용하는_값_정상처리(String status, BridgeGameStatus result) {
        Assertions.assertThat(BridgeGameStatus.getEnum(status)).isEqualTo(result);
    }
}