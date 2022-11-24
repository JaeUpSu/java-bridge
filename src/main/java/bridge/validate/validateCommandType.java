package bridge.validate;

import bridge.domain.GameCommand;
import bridge.exception.InvalidCommandTypeException;

public class validateCommandType {
    public static void validate(String inputValue) {

        GameCommand commandRetry = GameCommand.RETRY;
        GameCommand commandQuit = GameCommand.QUIT;

        if (inputValue.equals(commandRetry.getType())
                || inputValue.equals(commandQuit.getType())) {
            return;
        }

        throw new InvalidCommandTypeException();
    }
}
