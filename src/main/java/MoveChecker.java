public final class MoveChecker {

    private MoveChecker() {
        throw new AssertionError("정적 메서드만 보유한 객체입니다.");
    }

    public static boolean check(int randomNumber) {
        return randomNumber >= 4;
    }

}
