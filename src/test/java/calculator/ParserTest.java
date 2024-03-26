package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("파서 관련 테스트")
public class ParserTest {
    @Test
    @DisplayName("쉼표를 구분자로 하는 정수 문자열을 정수 리스트로 파싱")
    void parseByComma() {
        Parser parser = Parser.of("1,2,3");
        List<Integer> parsed = parser.find();
        assertThat(parsed.size()).isEqualTo(3);
        assertThat(parsed).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("콜론을 구분자로 하는 정수 문자열을 정수 리스트로 파싱")
    void parseByColon() {
        Parser parser = Parser.of("1:2:3");
        List<Integer> parsed = parser.find();
        assertThat(parsed.size()).isEqualTo(3);
        assertThat(parsed).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("커스텀 문자를 이용하여 정수 문자열을 정수 리스트로 파싱")
    void name() {
        Parser parser = Parser.of("//;\n1;2;3");
        List<Integer> parsed = parser.find();
        assertThat(parsed.size()).isEqualTo(3);
        assertThat(parsed).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("정규표현식 예약어가 구분자로 사용될 때 RuntimeException이 발생")
    void useDelimiterAsRegexComponent() {
        assertThatThrownBy(() -> Parser.of("//.\n1.2.3")).isInstanceOf(RuntimeException.class);
    }

}
