package bridge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BridgeGameResult {

    private final Map<Round, MoveStatus> result = new HashMap<>();

    public BridgeGameResult() {
    }

    public void add(Round round, MoveStatus status) {
        this.result.put(round, status);
    }

    public void reset() {
        result.clear();
    }

    public List<MoveStatus> get() {
        // List 객체 스트림
        // map result 객체를 list 의 get 적용
        // filter null 만 아니라면 collect
        return Round.order().stream()
                .map(result::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
