package bridge.exception;

public class InvalidMovingTypeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 움직이는 방향은 U 또는 D 를 입력해주세요.";

    public InvalidMovingTypeException() {
        super(ERROR_MESSAGE);
    }
}
