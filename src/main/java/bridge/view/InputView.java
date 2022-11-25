package bridge.view;


import bridge.validate.ValidateCommandType;
import bridge.validate.ValidateIsNumber;
import bridge.validate.ValidateMovingType;
import bridge.validate.ValidateRange;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String inputValue = Console.readLine();
            System.out.println(inputValue + "\n");
            validateBridgeSize(inputValue);
            return Integer.valueOf(inputValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public void printBridgeSizeMessage() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String inputValue = Console.readLine();
            System.out.println(inputValue + "\n");
            ValidateMovingType.validate(inputValue);

            return inputValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public void printMovingMessage() {
        System.out.println(READ_MOVING_MESSAGE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String inputValue = Console.readLine();
            System.out.println(inputValue + "\n");
            ValidateCommandType.validate(inputValue);

            return inputValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    public void printCommandMessage() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
    }

    private void validateBridgeSize(String inputValue) {
        ValidateIsNumber.validate(inputValue);
        ValidateRange.validate(Integer.valueOf(inputValue));
    }
}
