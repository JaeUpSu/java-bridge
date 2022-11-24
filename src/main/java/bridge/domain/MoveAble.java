package bridge.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum MoveAble {
    ALLOWANCE("O", (input, moving) -> input.equals(moving.getType())
            , (input, moving) -> input.equals(moving.getType())),
    DIS_ALLOWANCE("X", (input, moving) -> true
            , (input, moving) -> !input.equals(moving.getType())),
    EMPTY(" ", (input, moving) -> !input.equals(moving.getType())
            , (input, moving) -> input.equals(moving.getType()));

    private final String status;
    private final BiPredicate<String, MovingType> isBridgeMatch;
    private final BiPredicate<String, MovingType> isTypeMatch;

    MoveAble(String status, BiPredicate<String, MovingType> isBridgeMatch, BiPredicate<String, MovingType> isTypeMatch) {
        this.status = status;
        this.isBridgeMatch = isBridgeMatch;
        this.isTypeMatch = isTypeMatch;
    }

    public static String getMoveBridgeFilter(String input, MovingType movingType, MovingType correctType) {
        Stream<MoveAble> moveAbleStream = Arrays.stream(MoveAble.values())
                .filter(move -> move.isBridgeMatch.test(input, movingType));

        return getMovingTypeFilter(moveAbleStream, input, correctType);
    }

    private static String getMovingTypeFilter(Stream<MoveAble> moves, String input, MovingType correctType) {
        return moves.filter(move -> move.isTypeMatch.test(input, correctType))
                .findAny()
                .orElse(EMPTY)
                .getStatus();
    }
    private String getStatus() {
        return status;
    }
}
