package calculator;

import calculator.domains.Adder;
import calculator.domains.Parser;

public class CalculatorApp {
    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return Adder.sum(Parser.of(input).find());
    }
}
