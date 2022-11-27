package bridge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BridgeGameResult {

    private final Map<Round, MoveStatus> result = new HashMap<>();
    private final Map<Round, Direction> moves = new HashMap<>();

    public BridgeGameResult() {
    }

    public void add(Round round, MoveStatus status, Direction direction) {
        result.put(round, status);
        moves.put(round, direction);
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
                .map(round -> checkRound(round, direction))
                .collect(Collectors.toList());
    }

    private MoveStatus checkRound(Round round, Direction direction) {
        Direction moveDirection = moves.get(round);
        if (moveDirection != direction) {
            return MoveStatus.NOT_MOVE;
        }
        return result.get(round);
    }
}
