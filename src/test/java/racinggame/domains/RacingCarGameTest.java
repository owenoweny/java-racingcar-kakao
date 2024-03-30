package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.RandomGenerator;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingCarGameTest {
    @Test
    @DisplayName("게임 객체 생성 여부 확인")
    void isGameExist() {
        RacingCarGame g = RacingCarGame.newInstance();
        assertThatCode(() -> Objects.requireNonNull(g)).doesNotThrowAnyException();
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
        RacingCarGame racingCarGame = new RacingCarGame(Cars.of(List.of("car1", "car2", "car3")), randomGenerator);
        racingCarGame.processTurn();

        racingCarGame.cars()
                .values()
                .forEach(car -> {
                    assertThat(car.offset())
                            .isEqualTo(1);
                });
    }
}
