package bridge.view;


import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ENTER_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ENTER_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE_MESSAGE);
        int inputValue = Integer.valueOf(Console.readLine());
        return inputValue;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(ENTER_MOVING_MESSAGE);
        String inputValue = Console.readLine();
        return inputValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(ENTER_GAME_COMMAND_MESSAGE);
        String inputValue = Console.readLine();
        return inputValue;
    }
}
