package bridge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Round {

    public static final int MINIMUM_ROUND = 1;
    public static final int MAXIMUM_ROUND = 20;
    public static final int DIFFERENCE_ROUND = 1;

    private static final Map<Integer, Round> CACHE = new HashMap<>();

    private static final String INVALID_RANGE_MESSAGE = "허용된 범위를 벗어났습니다.";

    private Integer number;

    // Override 사용, Object 사용, getClass 사용
    // hashCode 사용 : 객체를 식별할 수 있는 유니크한 값, 중복안되는 고유의 값

    static {
        for (int i = MINIMUM_ROUND; i <= MAXIMUM_ROUND; i++) {
            CACHE.put(i, new Round(i));
        }
    }

    public static List<Round> order() {
        return IntStream.rangeClosed(MINIMUM_ROUND, MAXIMUM_ROUND)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Round> orderWithSize(int size) {
        validate(size);

        return IntStream.rangeClosed(MINIMUM_ROUND, size)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());
    }

    public static Round valueOf(Integer round) {
        validate(round);
        return CACHE.get(round);
    };

    public Round(Integer number) {
        validate(number);
        this.number = number;
    }

    public Round nextRound() {
        return CACHE.getOrDefault(number + DIFFERENCE_ROUND, this);
    }

    public static Round firstRound() {
        return CACHE.get(MINIMUM_ROUND);
    }

    public void reset() {
        number = MINIMUM_ROUND;
    }

    private static void validate(Integer number) {
        if (number < MINIMUM_ROUND || number > MAXIMUM_ROUND) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }
}
