package bridge.domain;

import java.util.function.Predicate;

public enum Moving {
    UP("U", (movingType) -> movingType == 1),
    DOWN("D", (movingType) -> movingType == 0);

    private final String type;
    private final Predicate<Integer> isMatch;

    Moving(String type, Predicate<Integer> isMatch) {
        this.type = type;
        this.isMatch = isMatch;
    }

    public String getType() {
        return type;
    }

    public Predicate<Integer> getIsMatch() {
        return isMatch;
    }
}
