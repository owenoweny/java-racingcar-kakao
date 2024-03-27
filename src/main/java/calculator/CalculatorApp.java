package calculator;

import calculator.domains.Numbers;

public class CalculatorApp {
    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return Numbers.fromRegex(input).sum();
    }
}
