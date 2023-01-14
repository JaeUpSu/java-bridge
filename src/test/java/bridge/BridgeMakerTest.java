package bridge;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

@DisplayName("BridgeMaker 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeMakerTest {

    // MethodSource 는 특정 메서드를 통해 반환되는 값을 인수로 가짐
    // List<Arguments> 는 유기적으로 구성한 구조의 리스트
    // Lists.newArrayList 는 통일된 타입의 값들로 이룬 리스트
    // 인터페이스는 implements 로 받음
    // @Override 를 통하여 인터페이스의 기존 메서드의 기능을 더 수술 가능

    @ParameterizedTest
    @MethodSource("makeBridgeTestArgumentProvider")
    void makeBridge_메서드는_다리의_길이를_입력받아_U와_D로_표현된_다리를_반환(List<Integer> numbers, int size, String[] expectes) {
        BridgeNumberGenerator numberGenerator = new TestBridgeNumberGenerator(numbers);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> result = bridgeMaker.makeBridge(size);

        Assertions.assertThat(result).containsExactly(expectes);
    }

    static List<Arguments> makeBridgeTestArgumentProvider() {
        return Arrays.asList(
                Arguments.of(Lists.newArrayList(1, 0, 1), 3, new String[]{"U", "D", "U"}),
                Arguments.of(Lists.newArrayList(0, 0, 0, 0), 4, new String[]{"D", "D", "D", "D"}),
                Arguments.of(Lists.newArrayList(0, 0, 1, 0, 1), 5, new String[]{"D", "D", "U", "D", "U"}),
                Arguments.of(Lists.newArrayList(1, 1, 1, 1, 1), 5, new String[]{"U", "U", "U", "U", "U"})
                );
    }

    static class TestBridgeNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestBridgeNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
