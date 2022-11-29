package bridge.domain;

public class PlayerMove {

    private final MoveStatus moveStatus;
    private final Direction direction;

    public PlayerMove(MoveStatus moveStatus, Direction direction) {
        this.moveStatus = moveStatus;
        this.direction = direction;
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
