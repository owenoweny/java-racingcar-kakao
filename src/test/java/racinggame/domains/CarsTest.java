package racinggame.domains;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.RandomGenerator;

import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("게임에 참가하는 자동차들 관련 테스트")
public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.of(List.of("pobi", "jseo", "owen"));
    }

    @Test
    @DisplayName("입력받은 차 이름을 바탕으로 객체를 초기화")
    void initialize() {
        assertThat(cars.values())
                .isEqualTo(List.of(
                        Car.of("pobi"),
                        Car.of("jseo"),
                        Car.of("owen")));
    }

    @Test
    @DisplayName("중복된 이름의 차를 가진 경우엔 예외를 발생")
    void filterDuplicated() {
        assertThatThrownBy(() -> Cars.of(List.of("jseo", "jseo"))).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("offset이 가장 큰 차가 우승자가 된다.")
    void chooseWinner() {
        List<Car> carList = cars.values();
        Car pobi = carList.get(0);
        Car jseo = carList.get(1);
        pobi.move();
        pobi.move();
        jseo.move();

        assertThat(cars.winners())
                .hasSize(1)
                .contains(pobi);
    }

    @Test
    @DisplayName("offset이 가장 큰 차가 여러 대일 경우, 모두 우승자가 된다.")
    void chooseWinners() {
        List<Car> carList = cars.values();
        Car pobi = carList.get(0);
        Car jseo = carList.get(1);
        pobi.move();
        jseo.move();

        assertThat(cars.winners())
                .hasSize(2)
                .contains(pobi)
                .contains(jseo);
    }

    @Test
    @DisplayName("한 턴을 진행한 후에 차가 유효하게 이동한다.")
    void processTurn() {
        RandomGenerator randomGenerator = new RandomGenerator() {
            @Override
            public int generate() {
                return 5;
            }
        };
        Cars cars = new Cars(
                List.of(
                        Car.of("car1"),
                        Car.of("car2"),
                        Car.of("car3")
                )
                , randomGenerator);
        cars.move();

        cars.values()
                .forEach(car -> {
                    Assertions.assertThat(car.offset())
                            .isEqualTo(1);
                });
    }
}
