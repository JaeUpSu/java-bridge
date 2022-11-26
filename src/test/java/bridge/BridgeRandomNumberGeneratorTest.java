package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeRandomNumberGenerator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeRandomNumberGeneratorTest {

    // 클래스에 해당 애노테이션을 붙이면 @Test 메소드 이름에 _로 표시한 모든 부분은 space로 처리된다.

    @Test
    void generate_0과_1사이의_무작위_값을_생성하여_반환한다() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int number = bridgeNumberGenerator.generate();

        Assertions.assertThat(number).isBetween(0, 1);
    }
}
