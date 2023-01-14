package bridge;

import bridge.domain.Direction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        // Stream 으로
        // generate 를 통해 generate 실행
        // limit 로 size 만큼
        // map 으로 하나하나 접근해 Direction.toInitialLetter 실행
        // collect 으로 리스트형태로 반환
        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(Direction::toCommand)
                .collect(Collectors.toList());
    }
}
