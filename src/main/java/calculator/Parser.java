package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private static final Pattern defaultInputFormatPattern = Pattern.compile("//(.)\n(.*)");
    private static final Pattern forbiddenDelimiterPattern = Pattern.compile("\\.|\\^|\\$|\\*|\\+|\\?|\\|");
    private final String delimiter;
    private final String targetString;

    private Parser(String delimiter, String targetString) {
        this.delimiter = delimiter;
        this.targetString = targetString;
    }

    public static Parser of(String input) {
        validateRegex(input);
        if (!input.startsWith("//")) {
            return new Parser(",|:", input);
        }
        Matcher m = defaultInputFormatPattern.matcher(input);
        if (!m.find()) {
            throw new RuntimeException("");
        }
        return new Parser(m.group(1), m.group(2));
    }

    private static void validateRegex(String input) {
        Matcher m = forbiddenDelimiterPattern.matcher(input);
        if (m.find()) {
            throw new RuntimeException("정규표현식 예약어를 사용할 수 없습니다.");
        }
    }

    public List<Integer> find() {
        return Arrays.stream(targetString.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
