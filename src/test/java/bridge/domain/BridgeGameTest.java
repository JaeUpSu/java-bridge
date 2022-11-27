package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.domain.MoveStatus.ABLE;
import static bridge.domain.MoveStatus.UNABLE;

@DisplayName("BridgeGame 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeGameTest {

    private final Bridge bridge = new Bridge(List.of("U", "D", "U"));
    private final BridgeGame bridgeGame = new BridgeGame(bridge);

    @Test
    void move_메서드는_라운드와_방향을_입력받아_정답인_경우_ABLE_를_반환() {
        MoveStatus status = bridgeGame.move(Round.valueOf(1), Direction.UP);

        Assertions.assertThat(status).isEqualTo(ABLE);
    }

    @Test
    void move_메서드는_라운드와_방향을_입력받아_오답인_경우_UNABLE_를_반환() {
        MoveStatus status = bridgeGame.move(Round.valueOf(2), Direction.UP);

        Assertions.assertThat(status).isEqualTo(UNABLE);
    }

    @Test
    void isPlayable_메서드는_진행_가능한_라운드를_입력받는_경우_true_를_반환() {
        Boolean result = bridgeGame.isPlayable(Round.valueOf(2));

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void isPlayable_메서드는_진행_불가능한_라운드를_입력받는_경우_false_를_반환_반환() {
        Boolean result = bridgeGame.isPlayable(Round.valueOf(4));

        Assertions.assertThat(result).isFalse();
    }

}
