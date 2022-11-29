package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.*;
import bridge.dto.GameMoveDto;
import bridge.dto.GameResultDto;

import java.util.List;
import java.util.Objects;

public class BridgeGameService {

    private static final String INVALID_GAME_STATE_MESSAGE = "게임을 진행할 수 없습니다.";
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void initializeBridgeGame(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        Bridge answerBridge = new Bridge(bridge);
        this.bridgeGame = new BridgeGame(answerBridge);
    }

    public GameMoveDto play(Player player, String move) {

        if (!isPlayable()) {
            throw new IllegalArgumentException(INVALID_GAME_STATE_MESSAGE);
        }

        player.move(bridgeGame, Direction.toEnum(move));
        return new GameMoveDto(player.getBridgeGameResult());
    }

    public boolean isPlayable() {
        if (isNotInitialized()) {
            return false;
        }
        return bridgeGame.isPlayable();
    }

    private boolean isNotInitialized() {
        return Objects.isNull(bridgeGame);
    }

    private boolean isNotContinuous(String command) {
        BridgeGameStatus bridgeGameStatus = BridgeGameStatus.getEnum(command);
        return bridgeGameStatus.isNotPlayable();
    }

    public GameResultDto gameOver(Player player) {
        GameMoveDto gameMoveDto = new GameMoveDto(player.getBridgeGameResult());
        return new GameResultDto(player.checkGamePassed(), gameMoveDto, player.getGamePlayCount());
    }

    public boolean isGameOver(Player player) {
        Victory result = player.checkGamePassed();
        return !isPlayable() && result.isVictory();
    }

    public void retry(Player player, String command) {
        if (isNotInitialized() || isNotContinuous(command)) {
            return;
        }
        bridgeGame.retry();
        player.reset();
    }
}
