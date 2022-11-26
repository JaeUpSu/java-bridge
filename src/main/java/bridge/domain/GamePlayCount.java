package bridge.domain;

public class GamePlayCount {

    private static final int PLAY_COUNT_START_ROUND = 1;

    private Integer count;

    private GamePlayCount(Integer count) {
        this.count = count;
    }

    public static GamePlayCount firstGame() {
        return new GamePlayCount(PLAY_COUNT_START_ROUND);
    }

    public void add() {
        count++;
    }

    public Integer get() {
        return count;
    }
}
