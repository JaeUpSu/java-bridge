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

    private static final List<Round> ORDER = createOrder();

    // Override 사용, Object 사용, getClass 사용
    // hashCode 사용 : 객체를 식별할 수 있는 유니크한 값, 중복안되는 고유의 값

    private static List<Round> createOrder() {
        return IntStream.range(MINIMUM_ROUND,MAXIMUM_ROUND)
                .mapToObj(Round::new)
                .collect(Collectors.toList());
    }

    private static final String INVALID_RANGE_MESSAGE = "허용된 범위를 벗어났습니다.";

    private Integer number;

    public Round(Integer number) {
        validate(number);
        this.number = number;
    }

    public void nextRound() {
        validate(++number);
    }

    public void reset() {
        number = MINIMUM_ROUND;
    }

    public static List<Round> getOrder() {
        return ORDER;
    }

    public static List<Round> order() {
        return IntStream.rangeClosed(MINIMUM_ROUND, MAXIMUM_ROUND)
                .mapToObj(Round::new)
                .collect(Collectors.toList());
    }

    private static void validate(Integer number) {
        if (number < MINIMUM_ROUND || number > MAXIMUM_ROUND) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round round = (Round) o;
        return Objects.equals(this.number, round.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
