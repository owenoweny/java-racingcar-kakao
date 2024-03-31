package racinggame;

import racinggame.domains.Cars;
import racinggame.domains.RacingCarGame;

public class RacingCarApplication {
    public RacingCarApplication() {
    }

    public void run() {
        Cars cars = Cars.of(ConsoleView.getCarNamesInput());
        int trialInput = ConsoleView.getTrialInput();
        RacingCarGame racingCarGame = new RacingCarGame(cars, trialInput);

        ConsoleView.printResultPrompt();
        while (!racingCarGame.isEnd()) {
            racingCarGame.processTurn();
            ConsoleView.printCarOffset(racingCarGame);
        }
        ConsoleView.printResult(racingCarGame);
    }

    public static void main(String[] args) {
        new RacingCarApplication().run();
    }
}
