package bridge.validate;

import bridge.domain.Moving;
import bridge.exception.InvalidMovingTypeException;

public class ValidateMovingType {
    public static void validate(String inputValue) {
        Moving MovingUp = Moving.UP;
        Moving MovingDown = Moving.DOWN;

        if (inputValue.equals(MovingUp.getType())
                || inputValue.equals(MovingDown.getType())) {
            return;
        }

        throw new InvalidMovingTypeException();
    }
}
