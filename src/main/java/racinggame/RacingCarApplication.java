package racinggame;

import racinggame.domains.RacingCarGame;

public class RacingCarApplication {
    public RacingCarApplication() {
    }

    public void run() {
        RacingCarGame racingCarGame = RacingCarGame.of(ConsoleView.getCarNamesInput());

        int trialInput = ConsoleView.getTrialInput();
        validateTrialInputRange(trialInput);

        ConsoleView.printResultPrompt();
        for (int repetition = 0; repetition < trialInput; repetition++) {
            racingCarGame.processTurn();
            ConsoleView.printCarOffset(racingCarGame);
        }
        ConsoleView.printResult(racingCarGame);
    }

    private static void validateTrialInputRange(int trialInput) {
        if (trialInput < 0) {
            throw new RuntimeException("0 이상의 수를 입력해주십시오.");
        }
    }

    public static void main(String[] args) {
        new RacingCarApplication().run();
    }
}
