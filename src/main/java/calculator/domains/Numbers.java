package calculator.domains;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers fromRegex(String regex) {
        List<Integer> parsed = Parser.parse(regex);
        return new Numbers(parsed);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
