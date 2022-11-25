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
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame.setBridge(bridge);
    }

    private void play() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getPrintingBridge());
        checkRetry();
    }

    private void printResult() {
        outputView.printResult(bridgeGame);
    }

    private void checkRetry() {
        if (bridgeGame.isFail()) {
            bridgeGame.updateRetry(inputView.readGameCommand());
        }
    }
}
