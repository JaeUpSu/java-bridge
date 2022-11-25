package bridge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MoveAbleTest {

    @DisplayName("이동 방향을 입력했을 때 모든 경우의수 정상 작동하는지")
    @MethodSource("getCorrectMoveValue")
    @ParameterizedTest
    void checkCorrectMovingTest(String input, MovingType bridgeType, MovingType stepType, String status) {

        String result = MoveAble.getMoveBridgeFilter(input, bridgeType, stepType);

        assertEquals(status, result, "[ERROR] 기댓값과 다르게 나옵니다.");
    }

    static Stream<Arguments> getCorrectMoveValue() {
        return Stream.of(
                // 입력값, MovingType 변환 값, 컴퓨터 Bridge 방향, 결과
                Arguments.of("U", MovingType.UP, MovingType.UP, "O"),
                Arguments.of("U", MovingType.UP, MovingType.DOWN, " "),
                Arguments.of("U", MovingType.DOWN, MovingType.UP, " "),
                Arguments.of("U", MovingType.DOWN, MovingType.DOWN, "X"),
                Arguments.of("D", MovingType.UP, MovingType.UP, "X"),
                Arguments.of("D", MovingType.UP, MovingType.DOWN, " "),
                Arguments.of("D", MovingType.DOWN, MovingType.UP, " "),
                Arguments.of("D", MovingType.DOWN, MovingType.DOWN, "O")
        );
    }

}
