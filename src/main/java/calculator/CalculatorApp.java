package calculator;

import java.util.Scanner;

public class CalculatorApp {
    public void run() {
        String input = new Scanner(System.in).nextLine();
        if (input == null || input.isBlank()) {
            System.out.println(0);
            return;
        }
        System.out.println(Adder.sum(Parser.of(input).find()));
    }

    public static void main(String[] args) {
        new CalculatorApp().run();
    }
}
