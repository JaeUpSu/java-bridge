package bridge.exception;

public class InvalidRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 다리 길이는 3 부터 20 사이의 수를 입력해주세요.";

    public InvalidRangeException() {
        super(ERROR_MESSAGE);
    }
}
