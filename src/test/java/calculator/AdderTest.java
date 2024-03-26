package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("덧셈기 유틸 테스트")
public class AdderTest {
    @Test
    @DisplayName("덧셈 정적 메서드는 리스트를 입력 받아 합산 결과를 반환")
    void addIntegerList() {
        assertThat(Adder.sum(List.of(1, 2, 3))).isEqualTo(6);
    }
}
