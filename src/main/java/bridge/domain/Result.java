package bridge.domain;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패");

    private final String status;

    Result(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
