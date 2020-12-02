package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @DisplayName("이름을 가진 자동차가 정상적으로 생성되는지 확인")
    @Test
    void constructorTest() {
        assertThat(new Car("asdf"))
            .isEqualToComparingFieldByField(new Car("asdf"));
    }

    @DisplayName("자동차 이름이 공백인지 확인")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "asdfas"})
    @ParameterizedTest
    void constructorTest2(final String input) {
        assertThatThrownBy(() -> new Car(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("부적절한 이름입니다.: %s", input);
    }
}
