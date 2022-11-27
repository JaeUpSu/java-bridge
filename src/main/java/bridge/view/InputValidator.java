package bridge.view;

import java.util.List;

public class InputValidator {

    // validator는 어떤 상황일 때 분리하는 것이 좋은건가요?? 기준 같은 것이나 분리한 이유
    // => 웹 페이지의 입력 값 경우에도 프론트에서 검증하고, 백엔드에서 한 번 더 검증하는 것 처럼 한 것

    private static final int VALID_BRIDGE_SIZE_LOWER_ROUND = 3;
    private static final int VALID_BRIDGE_SIZE_UPPER_ROUND = 20;
    private static final List<String> VALID_MOVING = List.of("U", "D");
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_BRIDGE_RANGE_MESSAGE = "다리의 길이는 3에서 20 사이의 숫자여야 합니다.";
    private static final String INVALID_MOVING_MESSAGE = "이동 방향은 위: U, 아래:D 중 하나여야 합니다.";

    public void validateBridgeSize(String inputSize) {
        Integer size = toInteger(inputSize);
        validateBridgeSizeRange(size);
    }

    public void validateMoving(String inputMoving) {
        if (!VALID_MOVING.contains(inputMoving)) {
            throw new IllegalArgumentException(INVALID_MOVING_MESSAGE);
        }
    }

    private Integer toInteger(String inputSize) {
        try {
            return Integer.valueOf(inputSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateBridgeSizeRange(Integer size) {
        if (size < VALID_BRIDGE_SIZE_LOWER_ROUND || VALID_BRIDGE_SIZE_UPPER_ROUND < size) {
            throw new IllegalArgumentException(INVALID_BRIDGE_RANGE_MESSAGE);
        }
    }
}
