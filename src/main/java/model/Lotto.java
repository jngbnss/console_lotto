package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto(List<Integer> lotto) {
        validate(lotto);
        this.numbers = lotto;
    }

    private void validate(List<Integer>numbers){
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size()!=LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>(numbers);
        if(unique.size()!=numbers.size()){
            throw new IllegalArgumentException("로또 번호는 중복될수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number<MIN_NUMBER||number>MAX_NUMBER){
                throw new IllegalArgumentException("로또 번호의 범위는 1~45입니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
