import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 객체 테스트")
public class CarTest {

    @Test
    @DisplayName("자동차가 움직임에 상태가 바뀜을 확인")
    void checkMoveState() {
        Car car = new Car("", 0);
        car.move();
        assertThat(car.status()).isEqualTo(1);
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
        Car car1 = Car.of("greater");
        Car car2 = Car.of("less");

        car1.move();

        assertThat(car1.compareTo(car2) > 0).isTrue();
    }
    
}
