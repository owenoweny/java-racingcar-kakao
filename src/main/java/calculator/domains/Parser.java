package calculator.domains;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private static final Pattern defaultInputFormatPattern = Pattern.compile("//(.)\n(.*)");
    private static final Pattern forbiddenDelimiterPattern = Pattern.compile("\\.|\\^|\\$|\\*|\\+|\\?|\\|");

    public static List<Integer> parse(String regex) {
        validateRegex(regex);
        if (!regex.startsWith("//")) {
            return splitByDelimiter(",|:", regex);
        }
        Matcher m = defaultInputFormatPattern.matcher(regex);
        if (!m.find()) {
            throw new RuntimeException("커스텀 구분자 입력 형식이 올바르지 않습니다.");
        }
        return splitByDelimiter(m.group(1), m.group(2));
    }

    private static List<Integer> splitByDelimiter(String delimiter, String targetString) {
        try {
            List<Integer> numbers = Arrays.stream(targetString.split(delimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateNegatives(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자를 입력할 수 없습니다.");
        }
    }

    private static void validateNegatives(List<Integer> numbers) {
        numbers.stream().filter(i -> i < 0)
                .findAny()
                .ifPresent((number) -> {
                    throw new RuntimeException("음수를 입력할 수 없습니다.");
                });
    }

    private static void validateRegex(String input) {
        Matcher m = forbiddenDelimiterPattern.matcher(input);
        if (m.find()) {
            throw new RuntimeException("정규표현식 예약어를 사용할 수 없습니다.");
        }
    }
}
