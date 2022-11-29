package bridge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeGameResult {

    private final Map<Round, PlayerMove> result = new HashMap<>();

    public BridgeGameResult() {
    }

    public void add(Round round, PlayerMove playerMove) {
        result.put(round, playerMove);
    }

    public void reset() {
        result.clear();
    }

    public List<List<MoveStatus>> getResult() {
        if (result.isEmpty()) {
            return List.of();
        }
        return List.of(getMoveResults(Direction.UP), getMoveResults(Direction.DOWN));
    }

    private List<MoveStatus> getMoveResults(Direction direction) {
        // List 객체 스트림
        // map result 객체를 list 의 get 적용
        // filter => Object::notNull,  null 만 아니라면 collect
        return Round.orderWithSize(result.size()).stream()
                .map(round -> getMoveResult(round, direction))
                .collect(Collectors.toList());
    }

    private MoveStatus getMoveResult(Round round, Direction direction) {
        PlayerMove playerMove = result.get(round);
        if (playerMove.isNotSameDirection(direction)) {
            return MoveStatus.NOT_MOVE;
        }
        return playerMove.getMoveStatus();
    }

    public Victory checkPassed() {
        long failCount = Round.orderWithSize(result.size()).stream()
                .map(result::get)
                .filter(PlayerMove::isFail)
                .count();

        return Victory.getEnum(failCount);
    }
}
