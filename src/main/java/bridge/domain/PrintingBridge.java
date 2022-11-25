package bridge.domain;

import java.util.List;
import java.util.StringJoiner;

public class PrintingBridge {

    StringJoiner upBridge;
    StringJoiner downBridge;

    public PrintingBridge() {
        this.upBridge = new StringJoiner(" | ", "[ ", " ]");
        this.downBridge = new StringJoiner(" | ", "[ ", " ]");
    }

    public void addMoveBridge(String userMove, MovingType computerMoveType) {
        upBridge.add(MoveAble.getMoveBridgeFilter(userMove, MovingType.UP, computerMoveType));
        downBridge.add(MoveAble.getMoveBridgeFilter(userMove, MovingType.DOWN, computerMoveType));
    }

    public String getBridgeMap() {
        return upBridge.toString() + "\n" +  downBridge.toString();
    }
}
