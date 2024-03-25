import java.util.List;

//Todo : rename
public final class Game {

    private Cars cars;
    private RandomGenerator randomGenerator;

    public Game(Cars cars) {
        this.cars = cars;
        this.randomGenerator = new RandomGenerator();
    }

    public Game() {
    }

    public static Game newInstance() {
        return new Game();
    }

    public static Game of(List<String> carNames) {
        return new Game(Cars.of(carNames));
    }

    public Cars cars() {
        return this.cars;
    }

    public void processTurn() {
        cars.list()
                .stream()
                .filter(e -> MoveChecker.check(randomGenerator.generate()))
                .forEach(Car::move);
    }
}
