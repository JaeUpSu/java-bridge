package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PlayerMove 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerMoveTest {

    @Test
    void isNotSameDirection_메서드는_입력_방향과_사용자의_방향이_다르면_true_반환() {
        PlayerMove playerMove = new PlayerMove(MoveStatus.ABLE, Direction.UP);
        assertThat(playerMove.isNotSameDirection(Direction.UP)).isFalse();
    }

    @Test
    void isFail_메서드는_사용자의_이동이_실패했을_경우_true_반환() {
        PlayerMove playerMove = new PlayerMove(MoveStatus.UNABLE, Direction.UP);
        assertThat(playerMove.isFail()).isTrue();
    }

    @Test
    void getMoveResult_메서드는_이동_성공_여부_반환() {
        PlayerMove playerMove = new PlayerMove(MoveStatus.UNABLE, Direction.UP);
        assertThat(playerMove.getMoveStatus()).isEqualTo(MoveStatus.UNABLE);
    }
}
