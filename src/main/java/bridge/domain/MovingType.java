package bridge.domain;

import bridge.exception.InvalidMovingTypeException;

import java.util.Arrays;
import java.util.function.Predicate;

public enum MovingType {
    UP("U", (movingType) -> movingType == 1),
    DOWN("D", (movingType) -> movingType == 0);

    private final String type;
    private final Predicate<Integer> isMatch;

    MovingType(String type, Predicate<Integer> isMatch) {
        this.type = type;
        this.isMatch = isMatch;
    }

    public static MovingType getMoving(int generate) {
        return Arrays.stream(MovingType.values())
                .filter(moving -> moving.isMatch.test(generate))
                .findAny()
                .orElseThrow(InvalidMovingTypeException::new);
    }

    public String getType() {
        return type;
    }

    public Predicate<Integer> getIsMatch() {
        return isMatch;
    }
}
