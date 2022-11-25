package bridge.domain;

import java.util.StringJoiner;

public class PrintingBridge {

    StringJoiner upBridge;
    StringJoiner downBridge;
    Boolean continueGame;

    public PrintingBridge() {
        this.upBridge = new StringJoiner(" | ", "[ ", " ]");
        this.downBridge = new StringJoiner(" | ", "[ ", " ]");
        this.continueGame = true;
    }

    public Boolean isContinueGame() {
        return continueGame;
    }

    public void addMoveBridge(String userMove, MovingType computerMoveType) {
        String nextUpState = MoveAble.getMoveBridgeFilter(userMove, MovingType.UP, computerMoveType);
        String nextDownState = MoveAble.getMoveBridgeFilter(userMove, MovingType.DOWN, computerMoveType);

        upBridge.add(nextUpState);
        downBridge.add(nextDownState);
        checkContinueGame(nextUpState, nextDownState);
    }

    public String getBridgeMap() {
        return upBridge.toString() + "\n" + downBridge.toString() + "\n";
    }

    private void checkContinueGame(String nextUpState, String nextDownState) {
        String disAllowance = MoveAble.DIS_ALLOWANCE.getStatus();

        if (nextUpState.contains(disAllowance) || nextDownState.contains(disAllowance)) {
            continueGame = false;
        }
    }
}
