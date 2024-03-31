package racinggame;

import racinggame.domains.Cars;
import racinggame.domains.RacingCarGame;

public class RacingCarApplication {
    private final ConsoleView consoleView;

    public RacingCarApplication(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void run() {
        Cars cars = Cars.of(consoleView.getCarNamesInput());
        int trialInput = consoleView.getTrialInput();
        RacingCarGame racingCarGame = new RacingCarGame(cars, trialInput);

        consoleView.printResultPrompt();
        while (!racingCarGame.isEnd()) {
            racingCarGame.processTurn();
            consoleView.printCarOffset(racingCarGame);
        }
        consoleView.printResult(racingCarGame);
    }

    public static void main(String[] args) {
        new RacingCarApplication(new ConsoleView()).run();
    }
}
