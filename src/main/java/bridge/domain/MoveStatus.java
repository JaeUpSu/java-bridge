package bridge.domain;

public enum MoveStatus {
    ABLE("O"),
    UNABLE("X");

    private final String status;

    MoveStatus(String status) {
        this.status = status;
    }

}
