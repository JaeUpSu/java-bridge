package bridge.domain;

public enum Range {
    MIN(3),
    MAX(20);

    private final Integer value;

    Range(Integer range) {
        this.value = range;
    }

    public Integer getValue() {
        return this.value;
    }
}
