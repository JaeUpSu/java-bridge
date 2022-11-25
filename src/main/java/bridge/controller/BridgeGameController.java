package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        outputView.printStart();
        createBridge();

        do {
            play();
        } while (bridgeGame.isContinue());

        printResult();
    }

    private void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView.printBridgeSizeMessage();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame.setBridge(bridge);
    }

    private void play() {
        inputView.printMovingMessage();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getPrintingBridge());
        checkRetry();
    }

    private void printResult() {
        outputView.printResult(bridgeGame);
    }

    private void checkRetry() {
        if (bridgeGame.isFail()) {
            inputView.printCommandMessage();
            bridgeGame.updateRetry(inputView.readGameCommand());
        }
    }
}
