package racinggame;

import racinggame.domains.RacingCarGame;

public class RacingCarApplication {
    public RacingCarApplication() {
    }

    public void run() {
        RacingCarGame racingCarGame = RacingCarGame.of(ConsoleView.getCarNamesInput());

        int trialInput = ConsoleView.getTrialInput();
        RacingCarGame.validateTrialInputRange(trialInput);

        ConsoleView.printResultPrompt();
        for (int repetition = 0; repetition < trialInput; repetition++) {
            racingCarGame.processTurn();
            ConsoleView.printCarOffset(racingCarGame);
        }
        ConsoleView.printResult(racingCarGame);
    }

    public static void main(String[] args) {
        new RacingCarApplication().run();
    }
}
