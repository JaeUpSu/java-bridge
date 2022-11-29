package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static bridge.domain.Direction.*;
import static bridge.domain.MoveStatus.NOT_MOVE;
import static org.assertj.core.api.Assertions.*;

@DisplayName("PlayerMove 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerMoveTest {

    @Test
    void isNotSameDirection_메서드는_입력_방향과_사용자의_방향이_다르면_true_반환() {
        PlayerMove playerMove = PlayerMove.UP_SUCCESS;
        assertThat(playerMove.isNotSameDirection(UP)).isFalse();
    }

    @Test
    void isFail_메서드는_사용자의_이동이_실패했을_경우_true_반환() {
        PlayerMove playerMove = PlayerMove.UP_FAIL;
        assertThat(playerMove.isFail()).isTrue();
    }

    @Test
    void getMoveResult_메서드는_이동_성공_여부_반환() {
        PlayerMove playerMove = PlayerMove.UP_FAIL;
        assertThat(playerMove.getMoveStatus()).isEqualTo(MoveStatus.UNABLE);
    }

    @ParameterizedTest
    @CsvSource({
            "UP, SUCCESS, UP_SUCCESS",
            "UP, FAIL, UP_FAIL",
            "DOWN, SUCCESS, DOWN_SUCCESS",
            "DOWN, FAIL, DOWN_FAIL"
    })
    void getEnum_메서드는_Direction과_MoveResult를_입력받아_PlayerMove를_반환한다(
            Direction direction,
            MoveStatus moveStatus,
            PlayerMove playerMove
    ) {
        assertThat(PlayerMove.getEnum(moveStatus, direction)).isEqualTo(playerMove);
    }

    @Test
    void getEnum_메서드는_올바르지_않은_값을_입력받으면_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> PlayerMove.getEnum(NOT_MOVE, UP))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 방향과 결과를 입력해주세요.");
    }
}
