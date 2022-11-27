package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.MoveStatus;
import bridge.domain.Player;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("BridgeGameService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeGameServiceTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGameService bridgeGameService;

    @BeforeEach
    void setup() {
        bridgeGameService = new BridgeGameService(bridgeMaker);
    }

    @Test
    void initializeBridgeGame_메서드는_다리_길이를_입력받아_BridgeGame_초기화() {
        int givenSize = 3;

        bridgeGameService.initializeBridgeGame(givenSize);
        Assertions.assertThat(bridgeGameService.isPlayable()).isTrue();
    }

    @Test
    void play_메서드는_사용자와_방향을_입력받아_다리를_건너_결과_반환() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestBridgeNumberGenerator(Lists.newArrayList(0,0,1)));
        BridgeGameService bridgeGameService = new BridgeGameService(bridgeMaker);
        bridgeGameService.initializeBridgeGame(3);

        List<List<MoveStatus>> result = bridgeGameService.play(new Player(), "U");

        Assertions.assertThat(result.get(0)).isEqualTo(List.of(MoveStatus.UNABLE));
    }

    @Test
    void play_메서드는_다리가_준비되지_않는_경우_예외처리() {
        Assertions.assertThatThrownBy(() -> bridgeGameService.play(new Player(), "U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임을 진행할 수 없습니다.");
    }

    @Test
    void isPlayable_메서드는_다리가_초기화되지_않은_경우_false_반환() {
        boolean result = bridgeGameService.isPlayable();
        Assertions.assertThat(result).isFalse();
    }

    static class TestBridgeNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestBridgeNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
