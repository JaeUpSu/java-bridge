package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.*;

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

    public List<List<MoveStatus>> play(Player player, String move) {

        if (!isPlayable()) {
            throw new IllegalArgumentException(INVALID_GAME_STATE_MESSAGE);
        }

        player.move(bridgeGame, Direction.toEnum(move));
        return player.getBridgeGameResult();
    }

    public boolean isPlayable() {
        if (!isInitialized()) {
            return false;
        }
        return bridgeGame.isPlayable();
    }

    private boolean isInitialized() {
        return !Objects.isNull(bridgeGame);
    }

    public void retry(String command) {
        if (!isInitialized()) {
            throw new IllegalArgumentException(INVALID_GAME_STATE_MESSAGE);
        }
        bridgeGame.retry(BridgeGameStatus.getEnum(command));
    }
}
