package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 객체 테스트")
public class CarTest {

    @Test
    @DisplayName("자동차가 움직임에 상태가 바뀜을 확인")
    void checkMoveState() {
        Car car = new Car("", 0);
        car.move();
        assertThat(car.offset()).isEqualTo(1);
    }

    @Test
    @DisplayName("이름이 다섯 글자가 넘는 경우 예외를 발생시킨다.")
    void validateLength() {
        assertThatThrownBy(() -> Car.of("123456"))
                .isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("자동차의 이름 보유를 검증")
    void checkCarName() {
        String name = "jseo";
        Car car = Car.of(name);
        assertThat(car.owner()).isEqualTo(name);
    }

    @Test
    @DisplayName("offset 필드가 큰 객체가 greater")
    void compareOffset() {
        Car car1 = Car.of("gt");
        Car car2 = Car.of("lt");

        car1.move();

        assertThat(car1.compareTo(car2) > 0).isTrue();
    }

}
