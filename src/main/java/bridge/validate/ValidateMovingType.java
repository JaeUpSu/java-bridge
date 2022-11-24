package bridge.validate;

import bridge.domain.MovingType;
import bridge.exception.InvalidMovingTypeException;

public class ValidateMovingType {
    public static void validate(String inputValue) {
        MovingType MovingUp = MovingType.UP;
        MovingType MovingDown = MovingType.DOWN;

        if (inputValue.equals(MovingUp.getType())
                || inputValue.equals(MovingDown.getType())) {
            return;
        }

        throw new InvalidMovingTypeException();
    }
}
