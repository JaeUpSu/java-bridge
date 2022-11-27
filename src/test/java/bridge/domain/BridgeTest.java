package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Bridge 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    // @ParameterizedTest -> 인수를 받아 테스트
    // assertThat(answer).isNotNull() -> 예외를 던지지 않고 값이 있는 것을 의미

    @ParameterizedTest
    @ValueSource(ints = {2, 21, 0})
    void Bridge_생성자는_허용되지_않은_길이의_다리를_입력받으면_예외처리한다(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThatThrownBy(() -> new Bridge(bridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 3부터 20 사이여야 힙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void Bridge_허용되는_길이의_다리를_입력받으면_정상처리한다(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        Bridge answerBridge = new Bridge(bridge);
        assertThat(answerBridge).isNotNull();
    }

    @Test
    void check_메서드는_허용되지_않은_다리의_위치를_입력받으면_예외처리한다() {
        Bridge answerBridge = new Bridge(List.of("U", "D", "U"));

        assertThatThrownBy(() -> answerBridge.check(Round.valueOf(4), Direction.UP))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 다리의 범위를 벗어났습니다.");
    }

    @Test
    void check_메서드는_정답인_다리의_위치를_입력받으면_ABLE_을_반환한다() {
        Bridge answerBridge = new Bridge(List.of("U", "D", "U"));

        MoveStatus status = answerBridge.check(Round.valueOf(1), Direction.UP);

        assertThat(status).isEqualTo(MoveStatus.ABLE);
    }

    @Test
    void check_메서드는_오답인_다리의_위치를_입력받으면_UNABLE_을_반환한다() {
        Bridge answerBridge = new Bridge(List.of("U", "D", "U"));

        MoveStatus status = answerBridge.check(Round.valueOf(1), Direction.DOWN);

        assertThat(status).isEqualTo(MoveStatus.UNABLE);
    }
}
