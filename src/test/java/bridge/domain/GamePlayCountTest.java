package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("GamePlayCount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GamePlayCountTest {

    @Test
    void firstGame_메서드는_1의_count_값을_가진_인스턴스_반환() {
        GamePlayCount gamePlayCount = GamePlayCount.firstGame();

        Assertions.assertThat(gamePlayCount.get()).isEqualTo(1);
    }

    @Test
    void add_메서드는_count_값을_1_늘림() {
        GamePlayCount gamePlayCount = GamePlayCount.firstGame();
        gamePlayCount.add();

        Assertions.assertThat(gamePlayCount.get()).isEqualTo(2);
    }
}
