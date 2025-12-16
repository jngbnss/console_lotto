package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;

    public static Lotto generate(){
        Random random = new Random();
        List<Integer> numbers = random.ints(1, MAX_NUMBER + 1)
                .distinct().limit(LOTTO_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
