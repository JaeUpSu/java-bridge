package bridge.view;

import bridge.domain.MoveStatus;
import bridge.dto.GameMoveDto;
import bridge.dto.GameResultDto;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "\n다리 건너기 게임을 시작합니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";
    private static final String MAP_MESSAGE_FORMAT = "[ {0} ]";
    private static final String MAP_MESSAGE_DELIMITER = " | ";
    private static final String RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String VICTORY_MESSAGE_FORMAT = "\n게임 성공 여부: {0}";
    private static final String COUNT_MESSAGE_FORMAT = "총 시도한 횟수: {0}";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameMoveDto gameMoveDto) {
        for (List<MoveStatus> statuses : gameMoveDto.getResult()) {
            System.out.println(getResultMessage(statuses));
        }
    }

    private String getResultMessage(List<MoveStatus> statuses) {
        return String.format(MAP_MESSAGE_FORMAT, statuses.stream()
                .map(MoveStatus::get)
                .collect(Collectors.joining(MAP_MESSAGE_DELIMITER))
        );
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultDto gameResultDto) {
        System.out.println(RESULT_MESSAGE);
        printMap(gameResultDto.getResult());
        System.out.println(String.format(VICTORY_MESSAGE_FORMAT, gameResultDto.getVictory()));
        System.out.println(String.format(COUNT_MESSAGE_FORMAT, gameResultDto.getCount()));
    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printError(String message) {
        System.out.println(MessageFormat.format(ERROR_MESSAGE_FORMAT, message));
    }
}
