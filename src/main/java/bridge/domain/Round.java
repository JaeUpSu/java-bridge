package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class Round {

    public static final int MINIMUM_ROUND = 1;
    public static final int MAXIMUM_ROUND = 20;

    private static final Map<Integer, Round> CACHE = new HashMap<>();
    private static final String INVALID_RANGE_MESSAGE = "허용된 범위를 벗어났습니다.";

    static {
        for (int i = MINIMUM_ROUND; i <= MAXIMUM_ROUND; i++) {
            CACHE.put(i, new Round(i));
        }
    }

    private final Integer number;

    private Round(Integer number) {
        this.number = number;
    }

    public static Round valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(Integer number) {
        if (number < MINIMUM_ROUND || number > MAXIMUM_ROUND) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }
}
