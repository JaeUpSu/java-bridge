package bridge.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum MoveAble {
    ALLOWANCE("O", (input, moving) -> input.equals(moving.getType())),
    DIS_ALLOWANCE("X", (input, moving) -> input.equals(moving.getType())),
    EMPTY(" ", (input, moving) -> !input.equals(moving.getType()));

    private final String status;
    private final BiPredicate<String, MovingType> isMatch;

    MoveAble(String status, BiPredicate<String, MovingType> isMatch) {
        this.status = status;
        this.isMatch = isMatch;
    }

    public static String getFilter(String input, MovingType movingType) {
        return Arrays.stream(MoveAble.values())
                .filter(move -> move.isMatch.test(input, movingType))
                .findAny()
                .orElse(EMPTY)
                .getStatus();
    }

    private String getStatus() {
        return status;
    }
}
