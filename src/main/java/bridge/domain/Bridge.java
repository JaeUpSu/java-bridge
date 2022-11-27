package bridge.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class Bridge {

    private static final int BRIDGE_LOWER_ROUND = 3;
    private static final int BRIDGE_UPPER_ROUND = 20;

    private static final String INVALID_BRIDGE_LENGTH_MESSAGE = "다리 길이는 3부터 20 사이여야 힙니다.";
    private static final String INVALID_ROUND_MESSAGE = "입력값이 다리의 범위를 벗어났습니다.";

    private final Map<Round, Direction> bridge;

    // Round 를 객체로 분리하고자 한 이유 : 답인지 확인할 때 인덱스로 접근하는 부분이 마음에 안듬
    // stream 메서드 boxed() : int, long, double => Integer, Long, Double 로 바꿔줌
    // Collectors.toMap : 원하는 형식의 Map 으로 정의

    public Bridge(List<String> bridge) {
        validate(bridge.size());
        this.bridge = toBridge(bridge);
    }

    public MoveStatus check(Round round, Direction direction) {
        if (!isValidRound(round)) {
            throw new IllegalArgumentException(INVALID_ROUND_MESSAGE);
        }

        return checkGameResult(round, direction);
    }

    private MoveStatus checkGameResult(Round round, Direction direction) {
        if (bridge.get(round) == direction) {
            return MoveStatus.ABLE;
        }
        return MoveStatus.UNABLE;
    }

    public boolean isValidRound(Round round) {
        return bridge.containsKey(round);
    }

    private void validateKeyContain(Round round) {
        if (!bridge.containsKey(round)) {
            throw new IllegalArgumentException(INVALID_ROUND_MESSAGE);
        }
    }

    private Map<Round, Direction> toBridge(List<String> bridge) {
        return mapRoundToDirection(Round.order(), toDirectionList(bridge));
    }

    private Map<Round, Direction> mapRoundToDirection(List<Round> order, List<Direction> toDirectionList) {
        return IntStream.range(0, toDirectionList.size())
                .boxed()
                .collect(toMap(order::get, toDirectionList::get));
    }

    private List<Direction> toDirectionList(List<String> bridge) {
        return bridge.stream()
                .map(Direction::toEnum)
                .collect(Collectors.toList());
    }

    private void validate(int size) {
        if (size < BRIDGE_LOWER_ROUND || size > BRIDGE_UPPER_ROUND) {
            throw new IllegalArgumentException(INVALID_BRIDGE_LENGTH_MESSAGE);
        }
    }
}
