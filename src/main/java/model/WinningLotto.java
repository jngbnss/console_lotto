package model;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이여야 합니다.");
        }
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다.");
        }
    }


    public int getBonusNumber() {
        return bonusNumber;
    }

    // 핵심: 내부 구조를 숨긴 메서드들
    public boolean contains(int number){
        return winningNumbers.getNumbers().contains(number);
    }

    public boolean isBonusNumber(int number){
        return bonusNumber==number;
    }

}
