package racinggame.domains;

import java.util.*;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);
        if (carSet.size() != cars.size()) {
            throw new InputMismatchException("자동차 이름은 고유해야합니다.");
        }
    }

    public static Cars of(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::of)
                .collect(Collectors.toList()));
    }

    public List<Car> list() {
        return cars;
    }

    public List<Car> winners() {
        cars.sort(Comparator.reverseOrder());
        return cars.stream()
                .filter(e -> cars.get(0).offset() <= e.offset())
                .collect(Collectors.toList());
    }
}
