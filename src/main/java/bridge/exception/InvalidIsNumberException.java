package bridge.exception;

public class InvalidIsNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    public InvalidIsNumberException() {
        super(ERROR_MESSAGE);
    }
}
