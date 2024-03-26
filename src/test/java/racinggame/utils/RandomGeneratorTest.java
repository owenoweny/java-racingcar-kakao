package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("랜덤 수를 생성 결과 테스트")
public class RandomGeneratorTest {
    @Test
    @DisplayName("0-9 사이 랜덤 값 발생 100,000회 확인")
    void checkRandom() {
        for (int i = 0; i < 100_000; i++) {
            assertThat(new RandomGenerator().generate())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }
}
