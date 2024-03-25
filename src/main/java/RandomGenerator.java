import java.util.Random;

public final class RandomGenerator {
    
    private static final Random random = new Random();

    private RandomGenerator() {
        throw new AssertionError("정적 메서드만 보유한 객체입니다.");
    }

    public static int generate() {
        return random.nextInt(10);
    }

}
