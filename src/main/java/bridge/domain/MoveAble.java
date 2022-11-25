package bridge.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum MoveAble {
    ALLOWANCE("O", (input, moving) -> input.equals(moving.getType())
            , (input, movingType) -> input.equals(movingType.getType())),
    DIS_ALLOWANCE("X", (input, moving) -> !input.equals(moving.getType())
            , (input, movingType) -> !input.equals(movingType.getType())),
    EMPTY(" ", (input, moving) -> input.equals(moving.getType())
            , (input, movingType) -> true);

    private final String status;
    private final BiPredicate<String, MovingType> isBridgeMatch;
    private final BiPredicate<String, MovingType> isMoveTypeMatch;

    MoveAble(String status, BiPredicate<String, MovingType> isBridgeMatch, BiPredicate<String, MovingType> isMoveTypeMatch) {
        this.status = status;
        this.isBridgeMatch = isBridgeMatch;
        this.isMoveTypeMatch = isMoveTypeMatch;
    }

    public static String getMoveBridgeFilter(String input, MovingType bridgeType, MovingType moveType) {
        Stream<MoveAble> moveAbleStream = Arrays.stream(MoveAble.values())
                .filter(move -> move.isBridgeMatch.test(input, bridgeType));

        return getMovingTypeFilter(moveAbleStream, input, moveType);
    }

    private static String getMovingTypeFilter(Stream<MoveAble> moves, String input, MovingType moveType) {
        return moves.filter(move -> move.isMoveTypeMatch.test(input, moveType))
                .findAny()
                .orElse(EMPTY)
                .getStatus();
    }
    public String getStatus() {
        return status;
    }
}
