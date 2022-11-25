package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameController controller = new BridgeGameController();
            controller.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
