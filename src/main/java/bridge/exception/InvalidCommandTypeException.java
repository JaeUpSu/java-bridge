package bridge.exception;

public class InvalidCommandTypeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 게임 명령어는 R 또는 Q 를 입력해주세요.";

    public InvalidCommandTypeException() {
        super(ERROR_MESSAGE);
    }
}
