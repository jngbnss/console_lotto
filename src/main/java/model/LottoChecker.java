package model;

public class LottoChecker {
    private final WinningLotto winningLotto;

    public LottoChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Rank check(Lotto lotto){
        int matchCount = countMatch(lotto);
        boolean bonusMatch= hasBonus(lotto);
        return Rank.valueOf(matchCount,bonusMatch);
    }

    private int countMatch(Lotto lotto) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if(winningLotto.contains(number)){
                count++;
            }
        }
        return count;
    }

    private boolean hasBonus(Lotto lotto) {
        for (Integer number : lotto.getNumbers()) {
            if(winningLotto.isBonusNumber(number)){
                return true;
            }
        }
        return false;
    }
}
