package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.MoveStatus;
import bridge.domain.Player;
import bridge.domain.Victory;
import bridge.dto.GameMoveDto;
import bridge.dto.GameResultDto;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("BridgeGameService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeGameServiceTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new TestBridgeNumberGenerator(Lists.newArrayList(0,0,1));
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGameService bridgeGameService;

    @BeforeEach
    void setup() {
        bridgeGameService = new BridgeGameService(bridgeMaker);
    }

    private void play(Player player, List<String> commands) {
        for (String command : commands) {
            bridgeGameService.play(player, command);
        }
    }

    @Test
    void gameOver_메서드는_사용자를_입력받아_GameResultDto를_반환한다() {
        bridgeGameService.initializeBridgeGame(3);
        Player player = new Player();
        play(player, List.of("D", "D", "U"));

        GameResultDto gameResultDto = bridgeGameService.gameOver(player);

        assertThat(gameResultDto.getCount()).isEqualTo(1);
        assertThat(gameResultDto.getVictory()).isEqualTo(Victory.VICTORY);
        assertThat(gameResultDto.getResult()).isInstanceOf(GameMoveDto.class);
    }

    @Test
    void initializeBridgeGame_메서드는_다리_길이를_입력받아_BridgeGame_초기화() {
        int givenSize = 3;

        bridgeGameService.initializeBridgeGame(givenSize);
        assertThat(bridgeGameService.isPlayable()).isTrue();
    }

    @Test
    void play_메서드는_사용자와_방향을_입력받아_다리를_건너_결과_반환() {
        bridgeGameService.initializeBridgeGame(3);

        GameMoveDto result = bridgeGameService.play(new Player(), "U");

        assertThat(result.getResult().get(0)).isEqualTo(List.of(MoveStatus.UNABLE));
    }

    @Test
    void play_메서드는_다리가_준비되지_않는_경우_예외처리() {
        assertThatThrownBy(() -> bridgeGameService.play(new Player(), "U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임을 진행할 수 없습니다.");
    }

    @Test
    void isPlayable_메서드는_다리가_초기화되지_않은_경우_false_반환() {
        boolean result = bridgeGameService.isPlayable();
        assertThat(result).isFalse();
    }

    @ParameterizedTest(name = "{0}을 입력받으면 재시작여부: {1}")
    @CsvSource({"R, true", "Q, false"})
    void retry_메서드는_command_를_입력받아_게임을_재시작_설정을_한다(String command, boolean result) {
        bridgeGameService.initializeBridgeGame(3);
        Player player = new Player();
        bridgeGameService.play(player, "U");

        bridgeGameService.retry(player, command);

        assertThat(bridgeGameService.isPlayable()).isEqualTo(result);
    }

    @Test
    void retry_메서드는_다리가_준비되지_않은경우_재시작하지_않고_그대로_반환() {
        bridgeGameService.retry(new Player(), "R");
        assertThat(bridgeGameService.isPlayable()).isFalse();
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
