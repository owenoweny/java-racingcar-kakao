package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {
    @Test
    @DisplayName("라운드 수가 유효하지 않은 경우 예외를 발생시킨다.")
    void validateTrialInput() {
        Cars cars = new Cars(List.of(), new RandomGenerator());
        assertThatThrownBy(() -> new RacingCarGame(cars, -1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("1 이상의 수를 입력해주십시오.");
    }

    @Test
    @DisplayName("라운드 수가 모두 진행된 이후에 이동할 경우, 예외를 발생시킨다.")
    void validateMove() {
        Cars cars = new Cars(List.of(), new RandomGenerator());
        RacingCarGame racingCarGame = new RacingCarGame(cars, 1);
        racingCarGame.processTurn();
        assertThatThrownBy(racingCarGame::processTurn)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이미 라운드가 종료되었습니다.");
    }
}
