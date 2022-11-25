package bridge.domain;

public enum Result {
    SUCCESS("성공"),
    CONTINUE("진행"),
    FAIL("실패");

    private final String status;

    Result(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
