package model;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_AMOUNT = 100_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("구입은 최대 100장입니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
