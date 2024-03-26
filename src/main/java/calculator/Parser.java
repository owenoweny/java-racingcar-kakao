package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private final String delimiter;
    private final String targetString;

    private Parser(String delimiter, String targetString) {
        this.delimiter = delimiter;
        this.targetString = targetString;
    }

    public static Parser of(String input) {
        if (!input.startsWith("//")) {
            return new Parser(",|:", input);
        }
        Matcher m = pattern.matcher(input);
        if (!m.find()) {
            throw new RuntimeException("");
        }
        return new Parser(m.group(1), m.group(2));
    }

    public List<Integer> find() {
        return Arrays.stream(targetString.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
