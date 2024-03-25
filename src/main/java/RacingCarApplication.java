import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarApplication {

    private final Scanner scanner = new Scanner(System.in);

    public RacingCarApplication() {
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameInput = scanner.nextLine();
        List<String> carNames = Arrays.stream(nameInput.split(",")).collect(Collectors.toList());
        RacingCarGame racingCarGame = RacingCarGame.of(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int trialInput = Integer.parseInt(scanner.nextLine());
        System.out.println();
        System.out.println("실행 결과");
        for (int reps = 0; reps < trialInput; reps++) {
            racingCarGame.processTurn();
            racingCarGame.showStatus();
            System.out.println();
        }

        String result = racingCarGame
                .cars()
                .winners()
                .stream()
                .map(e -> e.owner())
                .collect(Collectors.joining(","))
                + "가 최종 우승했습니다.";
        System.out.println(result);
    }

    public static void main(String[] args) {
        new RacingCarApplication().run();
    }

}
