package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThatCode;


@DisplayName("")
public class RacingCarGameTest {

    @Test
    @DisplayName("게임 객체 생성 여부 확인")
    void isGameExist() {
        RacingCarGame g = RacingCarGame.newInstance();
        assertThatCode(() -> Objects.requireNonNull(g)).doesNotThrowAnyException();
    }

}
