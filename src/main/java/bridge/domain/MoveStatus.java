package bridge.domain;

public enum MoveStatus {
    ABLE("O"),
    UNABLE("X"),
    NOT_MOVE(" ");

    private final String status;

    MoveStatus(String status) {
        this.status = status;
    }

    public String get() {
        return status;
    }

    public boolean isFail() {
        return this.equals(UNABLE);
    }
}
