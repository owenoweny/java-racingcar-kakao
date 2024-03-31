package racinggame.domains;

public final class RacingCarGame {
    private final Cars cars;
    private final int totalRound;
    private int moveCount;

    public RacingCarGame(Cars cars, int totalRound) {
        validateTrialInputRange(totalRound);
        this.cars = cars;
        this.totalRound = totalRound;
        this.moveCount = 0;
    }

    public Cars cars() {
        return this.cars;
    }

    public void processTurn() {
        checkEnd();
        moveCount++;
        cars.move();
    }

    public boolean isEnd() {
        return moveCount >= totalRound;
    }

    private void validateTrialInputRange(int trialInput) {
        if (trialInput < 1) {
            throw new RuntimeException("1 이상의 수를 입력해주십시오.");
        }
    }

    private void checkEnd() {
        if (isEnd()) {
            throw new RuntimeException("이미 라운드가 종료되었습니다.");
        }
    }
}
