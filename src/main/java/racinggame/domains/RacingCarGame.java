package racinggame.domains;

import racinggame.utils.RandomGenerator;

import java.util.List;

public final class RacingCarGame {
    private Cars cars;
    private RandomGenerator randomGenerator;

    public RacingCarGame(Cars cars, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public RacingCarGame() {
    }

    public static RacingCarGame newInstance() {
        return new RacingCarGame();
    }

    public static RacingCarGame of(List<String> carNames) {
        return new RacingCarGame(Cars.of(carNames), new RandomGenerator());
    }

    public Cars cars() {
        return this.cars;
    }

    public void processTurn() {
        cars.values()
                .stream()
                .filter(e -> MoveChecker.check(randomGenerator.generate()))
                .forEach(Car::move);
    }

    public static void validateTrialInputRange(int trialInput) {
        if (trialInput < 1) {
            throw new RuntimeException("1 이상의 수를 입력해주십시오.");
        }
    }
}
