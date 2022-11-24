package bridge.validate;

import bridge.domain.Range;
import bridge.exception.InvalidRangeException;

public class ValidateRange {
    public static void validate(Integer size) {
        Range RangeMin = Range.MIN;
        Range RangeMax = Range.MAX;

        if (RangeMin.getValue() <= size
                && size <= RangeMax.getValue()) {
            return;
        }

        throw new InvalidRangeException();
    }
}
