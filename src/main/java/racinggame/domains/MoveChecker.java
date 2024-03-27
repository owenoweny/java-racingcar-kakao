package racinggame.domains;

public final class MoveChecker {
    public static final int MOVE_THRESHOLD = 4;

    private MoveChecker() throws InstantiationException {
        throw new InstantiationException("정적 메서드만 보유한 객체입니다.");
    }

    public static boolean check(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
