package racinggame;

import racinggame.domains.Car;
import racinggame.domains.RacingCarGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class ConsoleView {
    private static final Scanner scanner = new Scanner(System.in);

    private static void printCarNamesInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public List<String> getCarNamesInput() {
        printCarNamesInputPrompt();
        String nameInput = scanner.nextLine();
        return Arrays.stream(nameInput.split(","))
                .collect(Collectors.toList());
    }

    private void printTrialInputPrompt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int getTrialInput() {
        printTrialInputPrompt();
        return Integer.parseInt(scanner.nextLine());
    }

    public void printResultPrompt() {
        System.out.println("\n실행 결과");
    }

    public void printResult(RacingCarGame racingCarGame) {
        String gameResultMessage = racingCarGame
                .cars()
                .winners()
                .stream()
                .map(Car::owner)
                .collect(Collectors.joining(","))
                + "가 최종 우승했습니다.";
        System.out.println(gameResultMessage);
    }

    public void printCarOffset(RacingCarGame racingCarGame) {
        racingCarGame.cars()
                .values()
                .forEach(e -> System.out.println(e.owner() + " : " + "-".repeat(e.offset())));
        System.out.println();
    }
}
