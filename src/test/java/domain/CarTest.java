package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("이름을 가진 자동차가 정상적으로 생성되는지 확인")
    @Test
    void constructorTest() {
        assertThat(new Car("asdf"))
            .isEqualToComparingFieldByField(new Car("asdf"));
    }
}
