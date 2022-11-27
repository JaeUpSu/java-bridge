package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private BridgeGameStatus bridgeGameStatus;

    public BridgeGame(Bridge bridge) {
        this(bridge, BridgeGameStatus.gameStart());
    }

    public BridgeGame(Bridge bridge, BridgeGameStatus bridgeGameStatus) {
        this.bridge = bridge;
        this.bridgeGameStatus = bridgeGameStatus;
    }

    public boolean isPlayable(Round round) {
        return bridge.isValidRound(round);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveStatus move(Round round, Direction direction) {
        MoveStatus status = bridge.check(round, direction);
        checkGameOver(round, status);
        return status;
    }

    private void checkGameOver(Round round, MoveStatus status) {
        if (bridge.isLastRound(round) || status.isFail()) {
            bridgeGameStatus = BridgeGameStatus.QUIT;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(BridgeGameStatus bridgeGameStatus) {
        this.bridgeGameStatus = bridgeGameStatus;
    }

    public boolean isPlayable() {
        return bridgeGameStatus.isPlayable();
    }
}
