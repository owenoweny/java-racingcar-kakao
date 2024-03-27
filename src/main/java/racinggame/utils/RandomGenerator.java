package racinggame.utils;

import java.util.Random;

public class RandomGenerator {
    public static final int MAX_RANDOM_NUMBER = 10;
    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public int generate() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
