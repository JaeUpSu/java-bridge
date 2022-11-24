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
    private final BiPredicate<String, MovingType> isMoveMatch;

    MoveAble(String status, BiPredicate<String, MovingType> isBridgeMatch, BiPredicate<String, MovingType> isMoveMatch) {
        this.status = status;
        this.isBridgeMatch = isBridgeMatch;
        this.isMoveMatch = isMoveMatch;
    }

    public static String getMoveBridgeFilter(String input, MovingType bridgeType, MovingType moveAbleType) {
        Stream<MoveAble> moveAbleStream = Arrays.stream(MoveAble.values())
                .filter(move -> move.isBridgeMatch.test(input, bridgeType));

        return getMovingTypeFilter(moveAbleStream, input, moveAbleType);
    }

    private static String getMovingTypeFilter(Stream<MoveAble> moves, String input, MovingType moveAbleType) {
        return moves.filter(move -> move.isMoveMatch.test(input, moveAbleType))
                .findAny()
                .orElse(EMPTY)
                .getStatus();
    }
    private String getStatus() {
        return status;
    }
}
