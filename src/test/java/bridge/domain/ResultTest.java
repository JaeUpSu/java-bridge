package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @DisplayName("모든 상태 값이 제대로 나오는지 확인.")
    @CsvSource(value = {"SUCCESS:성공","CONTINUE:진행","FAIL:실패"}, delimiter = ':')
    @ParameterizedTest
    void checkResultStatus(Result result, String expected) {
        assertEquals(result.getStatus()
                ,expected
                ,"[ERROR] 기댓값과 다르게 나옵니다.");
    }
}
