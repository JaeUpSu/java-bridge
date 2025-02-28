package bridge;

import bridge.domain.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Bridge bridge;
    PrintingBridge printingBridge;
    Integer position;
    Integer tryCount;
    Result result;

    public BridgeGame() {
        this.printingBridge = new PrintingBridge();
        this.position = 0;
        this.tryCount = 1;
        this.result = Result.CONTINUE;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public String getPrintingBridge() {
        return printingBridge.getBridgeMap();
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public String getResultStatus() {
        return result.getStatus();
    }

    public Boolean isContinue() {
        return result.equals(Result.CONTINUE);
    }

    public Boolean isFail() {
        return result.equals(Result.FAIL);
    }

    public Boolean isSuccess() {
        return result.equals(Result.SUCCESS);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        printingBridge.addMoveBridge(move, MovingType.getMoving(bridge.get(position)));
        position++;
        checkGame();
    }

    private void checkGame() {
        if (position.equals(bridge.size())) {
            result = Result.SUCCESS;
        }

        if (!printingBridge.isContinueGame()) {
            result = Result.FAIL;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.printingBridge = new PrintingBridge();
        position = 0;
        tryCount++;
    }

    public void updateRetry(String retry) {
        if (retry.equals(GameCommand.RETRY.getType())) {
            result = Result.CONTINUE;
            retry();
        }
    }
}
