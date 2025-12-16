package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    void 정상_구입_1000원() {
        PurchaseAmount amount = new PurchaseAmount(1000);
        assertThat(amount.getAmount()).isEqualTo(1000);
    }

    @Test
    void 정상1000원이면_로또_1장() {
        PurchaseAmount amount = new PurchaseAmount(1000);
        assertThat(amount.getLottoCount()).isEqualTo(1);
    }

    @Test
    void 정상8000원이면_로또_8장() {
        PurchaseAmount amount = new PurchaseAmount(8000);
        assertThat(amount.getLottoCount()).isEqualTo(8);
    }

    @Test
    void 구입금액_0원이면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다");
    }

    @Test
    void 구입금액_음수면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다");
    }

    @Test
    void 최대_100장_초과시_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(101000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 100장");
    }

    @Test
    void 예외1000원_단위가_아니면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원");
    }
}
