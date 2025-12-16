import static org.assertj.core.api.Assertions.*;

import java.util.List;
import model.Lotto;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호는_6개여야_한다() {
        assertThatThrownBy(() ->
                new Lotto(List.of(1, 2, 3, 4, 5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_중복될_수_없다() {
        assertThatThrownBy(() ->
                new Lotto(List.of(1, 2, 3, 4, 5, 5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_1부터_45_사이여야_한다() {
        assertThatThrownBy(() ->
                new Lotto(List.of(0, 1, 2, 3, 4, 5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_로또_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
