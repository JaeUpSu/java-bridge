package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static bridge.domain.MoveStatus.*;

@DisplayName("BridgeGameResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeGameResultTest {

    @Test
    void add_메서드는_해당_라운드의_게임_결과_입력() {
        BridgeGameResult gameResult = new BridgeGameResult();
        gameResult.add(Round.valueOf(1), ABLE);

        Assertions.assertThat(gameResult.get()).containsExactly(ABLE);
    }

    @Test
    void get_메서드는_1라운드_부터_게임_결과를_반환() {
        BridgeGameResult gameResult = new BridgeGameResult();
        gameResult.add(Round.valueOf(1), ABLE);
        gameResult.add(Round.valueOf(2), UNABLE);
        gameResult.add(Round.valueOf(3), ABLE);

        Assertions.assertThat(gameResult.get()).containsExactly(ABLE, UNABLE, ABLE);
    }

    @Test
    void reset_메서드는_게임_결과_초기화() {
        BridgeGameResult gameResult = new BridgeGameResult();
        gameResult.add(Round.valueOf(1), ABLE);
        gameResult.add(Round.valueOf(2), UNABLE);
        gameResult.add(Round.valueOf(3), ABLE);
        gameResult.add(Round.valueOf(4), ABLE);
        gameResult.reset();

        Assertions.assertThat(gameResult.get()).isEmpty();
    }
}
