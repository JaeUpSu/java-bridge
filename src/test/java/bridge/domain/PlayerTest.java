package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

@DisplayName("Player 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void move_메서드는_방향을_입력받아_다리_건너기_게임을_진행() {
        Player player = new Player();
        BridgeGame mock = mock(BridgeGame.class);

        player.move(mock, Direction.UP);

        verify(mock, only()).move(any(Round.class), eq(Direction.UP));
    }

    @Test
    void reset_메서드는_Round_와_BridgeGameResult_를_초기화_재시도_횟수_증가() {
        GamePlayCount gamePlayCount = mock(GamePlayCount.class);
        Round round = mock(Round.class);
        BridgeGameResult bridgeGameResult = mock(BridgeGameResult.class);

        Player player = new Player(gamePlayCount, round, bridgeGameResult);

        player.reset();

        verify(gamePlayCount, only()).add();
        verify(round, only()).reset();
        verify(bridgeGameResult, only()).reset();
    }

    @Test
    void getGameResult_메서드는_BridgeGameResult_의_get_을_호출() {
        BridgeGameResult bridgeGameResult = mock(BridgeGameResult.class);
        Player player = new Player(GamePlayCount.firstGame(), new Round(), bridgeGameResult);

        player.getBridgeGameResult();

        verify(bridgeGameResult, only()).get();
    }
}