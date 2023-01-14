package bridge.domain;

import java.util.Arrays;

import static bridge.domain.Direction.DOWN;
import static bridge.domain.Direction.UP;
import static bridge.domain.MoveStatus.UNABLE;
import static bridge.domain.MoveStatus.ABLE;

public enum PlayerMove {

    UP_SUCCESS(UP, ABLE),
    UP_FAIL(UP, UNABLE),
    DOWN_SUCCESS(DOWN, ABLE),
    DOWN_FAIL(DOWN, UNABLE);
    private final MoveStatus moveStatus;
    private final Direction direction;
    private static final String INVALID_PLAYER_MOVE_MESSAGE = "올바른 방향과 결과를 입력해주세요.";

    PlayerMove(Direction direction, MoveStatus moveStatus) {
        this.moveStatus = moveStatus;
        this.direction = direction;
    }

    public static PlayerMove getEnum(MoveStatus status, Direction direction) {
        return Arrays.stream(PlayerMove.values())
                .filter(playerMove -> playerMove.direction == direction)
                .filter(playerMove -> playerMove.moveStatus == status)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_MOVE_MESSAGE));
    }

    public boolean isNotSameDirection(Direction direction) {
        return this.direction.isNotSameDirection(direction);
    }

    public boolean isFail() {
        return moveStatus.isFail();
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }
}
