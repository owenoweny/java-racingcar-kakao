import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Move 관련 유틸 테스트")
public class MoveCheckerTest {

    @ParameterizedTest
    @DisplayName("4이상의 수를 입력 받았을 때 움직일 수 있음으로 판단")
    @CsvSource(value = {"3:false", "4:true"}, delimiter = ':')
    void checkMovable(int pickedNumber, boolean result) {
        assertThat(MoveChecker.check(pickedNumber)).isEqualTo(result);
    }

}
