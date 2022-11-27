package bridge.domain;

import java.util.List;

public class Player {

    private final GamePlayCount gamePlayCount;
    private final BridgeGameResult bridgeGameResult;
    private Round round;

    public Player() {
        this(GamePlayCount.firstGame(), Round.firstRound(), new BridgeGameResult());
    }

    public Player(GamePlayCount gamePlayCount, Round round, BridgeGameResult bridgeGameResult) {
        this.gamePlayCount = gamePlayCount;
        this.round = round;
        this.bridgeGameResult = bridgeGameResult;
    }

    public void move(BridgeGame bridgeGame, Direction direction) {
        MoveStatus status = bridgeGame.move(round, direction);
        bridgeGameResult.add(round, status, direction);
        round.nextRound();
    }

    public void reset() {
        bridgeGameResult.reset();
        round.reset();
        gamePlayCount.add();
    }

    public List<List<MoveStatus>> getBridgeGameResult() {
        return bridgeGameResult.getResult();
    }
}
