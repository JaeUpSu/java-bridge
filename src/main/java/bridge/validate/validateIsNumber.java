package bridge.validate;

import bridge.exception.InvalidIsNumberException;

public class validateIsNumber {
    public static void validate(String inputValue) {
        try {
            Integer.valueOf(inputValue);
        } catch (Exception e) {
            throw new InvalidIsNumberException();
        }
    }
}
