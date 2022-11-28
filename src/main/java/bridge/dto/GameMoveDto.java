package bridge.dto;

import bridge.domain.MoveStatus;

import java.util.List;

public class GameMoveDto {

    private final List<List<MoveStatus>> result;

    public GameMoveDto(List<List<MoveStatus>> result) {
        this.result = result;
    }

    public List<List<MoveStatus>> getResult() {
        return result;
    }
}
