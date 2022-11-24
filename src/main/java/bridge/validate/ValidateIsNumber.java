package bridge.validate;

import bridge.exception.InvalidIsNumberException;

public class ValidateIsNumber {
    public static void validate(String inputValue) {
        try {
            Integer.valueOf(inputValue);
        } catch (Exception e) {
            throw new InvalidIsNumberException();
        }
    }
}
