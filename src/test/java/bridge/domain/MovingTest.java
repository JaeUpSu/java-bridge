package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MovingTest {

    @DisplayName("generate 를 Moving 으로 변환하는 메서드 확인")
    @MethodSource("getCorrectValue")
    @ParameterizedTest
    void checkCorrectMovingTest(Integer generate, Moving moving) {
        if (Moving.getMoving(generate).equals(moving)) {
            return;
        }

        throw new IllegalArgumentException("generate 값이 정상적인 Moving 값으로 변환 안됩니다.");
    }

    static Stream<Arguments> getCorrectValue() {
        return Stream.of(
                Arguments.of(1, Moving.UP),
                Arguments.of(0, Moving.DOWN)
        );
    }
}
