package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public List<Integer> parse(String input) {
        if (input.startsWith("//")) {
            return parseCustom(input);
        }
        return parseDefault(input);
    }

    private List<Integer> parseDefault(String input) {
        return split(",|:", input);
    }

    private List<Integer> parseCustom(String input) {
        Matcher m = pattern.matcher(input);
        if (!m.find()) {
            throw new RuntimeException("");
        }
        return split(m.group(1), m.group(2));
    }

    private List<Integer> split(String regex, String input) {
        return Arrays.stream(input.split(regex))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
